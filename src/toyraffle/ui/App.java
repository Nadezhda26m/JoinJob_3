package toyraffle.ui;

import config.Config;
import toyraffle.mvp.LogPrizesTXT;
import toyraffle.mvp.Presenter;
import toyraffle.mvp.modeldb.ModelCSV;

import java.io.IOException;

public class App {
    public static void button() throws IOException {
        Presenter p = new Presenter(
                new ModelCSV(Config.pathDB, "presents"),
                new LogPrizesTXT(Config.pathDB, "waitlist"),
                new ViewConsole());
        String[] commandsRaffle = new String[]{
                "Розыгрыш игрушки",
                "Получить приз",
                "Настройки",
                "Выход"
        };
        String[] commandsSettings = new String[]{
                "Добавить новую игрушку",
                "Изменить вероятность выпадения игрушки",
                "Увеличить количество игрушек",
                "Уменьшить количество игрушек",
                "Удалить игрушку",
                "Посмотреть количество призов"
        };
        int command;
        boolean flag = true;
        p.view.printText("Розыгрыш игрушек в магазине детских товаров");
        while (flag) {
            p.view.printCommands(commandsRaffle);
            command = p.view.getIndexCommand(commandsRaffle);
            if (command == 0) p.getRandomPrize();
            else if (command == 1) p.givePrize();
            else if (command == 2) {
                p.view.printCommands(commandsSettings);
                command = p.view.getIndexCommand(commandsSettings);
                switch (command){
                    case 0 -> p.addToy();
                    case 1 -> p.changeWeightToy();
                    case 2 -> p.increaseCountToy();
                    case 3 -> p.decreaseCountToy();
                    case 4 -> p.delToy();
                    case 5 -> p.showTotalCountToys();
                }
                System.out.println();
            } else flag = false;
        }
    }
}
