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
                "Посмотреть количество призов",
                "Посмотреть список игрушек",
                "Выход из настроек"
        };
        appMenu(p, commandsRaffle, commandsSettings);
    }

    private static void settings(Presenter p, String[] commandsSettings) {
        int command;
        boolean flag = true;
        while (flag) {
            p.view.printCommands(commandsSettings);
            command = p.view.getIndexCommand(commandsSettings);
            switch (command) {
                case 0 -> p.addToy();
                case 1 -> {
                    if (checkDB(p)) p.changeWeightToy();
                }
                case 2 -> {
                    if (checkDB(p)) p.increaseCountToy();
                }
                case 3 -> {
                    if (checkDB(p)) p.decreaseCountToy();
                }
                case 4 -> {
                    if (checkDB(p)) p.delToy();
                }
                case 5 -> p.showTotalCountToys();
                case 6 -> {
                    if (checkDB(p)) p.showPresents();
                }
                case 7 -> flag = false;
            }
        }
    }

    private static void appMenu(Presenter p, String[] commandsRaffle,
                                String[] commandsSettings) {
        int command;
        boolean flag = true;
        p.view.printText("Розыгрыш игрушек в магазине детских товаров");
        while (flag) {
            p.view.printCommands(commandsRaffle);
            command = p.view.getIndexCommand(commandsRaffle);
            switch (command) {
                case 0 -> {
                    if (p.isEmptyDB()) {
                        p.view.printText("Подарки не найдены. " +
                                "Зайдите в настройки и добавьте игрушки.");
                    } else p.getRandomPrize();
                }
                case 1 -> {
                    if (p.isEmptyLog()) {
                        p.view.printText("Все призы разобрали)");
                    } else p.givePrize();
                }
                case 2 -> settings(p, commandsSettings);
                case 3 -> {
                    flag = false;
                    p.view.printText("\nВыход из программы");
                }
            }
        }
    }

    private static boolean checkDB(Presenter p) {
        if (p.isEmptyDB()) {
            p.view.printText("Подарки не найдены. " +
                    "Добавьте игрушку в настройках.");
            return false;
        }
        return true;
    }
}
