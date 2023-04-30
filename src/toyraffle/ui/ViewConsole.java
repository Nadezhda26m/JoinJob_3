package toyraffle.ui;

import toyraffle.mvp.Presents;
import toyraffle.mvp.Toy;
import toyraffle.mvp.View;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ViewConsole implements View {
    private Scanner scan = new Scanner(System.in);

    @Override
    public String getNameToy(int minCountChars) {
        System.out.print("Введите название игрушки: ");
        String name = scan.nextLine();
        if (name.length() >= minCountChars)
            return name;
        System.out.printf("Должно быть не меньше %d символов, повторите ввод\n", minCountChars);
        return getNameToy(minCountChars);
    }

    @Override
    public int getCountToy() {
        System.out.print("Введите количество игрушек: ");
        String num = scan.nextLine();
        if (this.isNumber(num)) {
            int number = Integer.parseInt(num);
            if (number > 0)
                return number;
        }
        System.out.println("Неверные данные, повторите ввод");
        return getCountToy();
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public int getWeightToy(int minWeight, int maxWeight) {
        System.out.printf("Введите вес (процент выпадения) игрушки (от %d до %d вкл.): ",
                minWeight, maxWeight);
        String num = scan.nextLine();
        if (this.isNumber(num)) {
            int number = Integer.parseInt(num);
            if (number >= minWeight && number <= maxWeight)
                return number;
        }
        System.out.println("Неверные данные, повторите ввод");
        return getWeightToy(minWeight, maxWeight);
    }

    @Override
    public int getIndexToy(ArrayList<Toy> presents) {
        System.out.print("Введите номер id игрушки: ");
        String num = scan.nextLine();
        if (this.isNumber(num)) {
            int number = Integer.parseInt(num);
            if (number > 0)
                for (int i = 0; i < presents.size(); i++)
                    if (number == presents.get(i).getId())
                        return i;
        }
        System.out.println("Неверные данные, повторите ввод");
        return getIndexToy(presents);
    }

    @Override
    public String getNameWinner() {
        return String.valueOf(NamesWinners.values()
                [new Random().nextInt(NamesWinners.values().length)]);
    }

    @Override
    public int getIndexCommand(String[] commands) {
        System.out.print("Введите номер команды: ");
        String num = scan.nextLine();
        if (this.isNumber(num)) {
            int number = Integer.parseInt(num);
            if (number > 0 && number <= commands.length)
                return number - 1;
        }
        System.out.println("Неверные данные, повторите ввод");
        return getIndexCommand(commands);
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }

    @Override
    public void printPresents(Presents presents) {
        System.out.println("Список разыгрываемых игрушек: ");
        System.out.print(presents);
    }

    @Override
    public void printCommands(String[] commands) {
        System.out.println("Список команд: ");
        int size = commands.length;
        for (int i = 0; i < size; i++) {
            System.out.printf("%d. %s\n", i + 1, commands[i]);
        }
    }

    @Override
    public boolean confirmAction() {
        System.out.print("Подтвердите действие (yes/no): ");
        String s = scan.nextLine();
        if (s.equalsIgnoreCase("yes")) return true;
        if (s.equalsIgnoreCase("no")) return false;
        System.out.println("Неверные данные");
        return confirmAction();
    }
}
