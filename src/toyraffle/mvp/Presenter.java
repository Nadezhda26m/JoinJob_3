package toyraffle.mvp;

import java.util.Random;

public class Presenter {
    protected ModelDB model;
    protected LogPrizesTXT log;
    public View view;
    private Random rand = new Random();
    public Presenter (ModelDB model, LogPrizesTXT log, View currentView){
        this.model = model;
        this.log = log;
        this.view = currentView;
    }

    public void getRandomPrize(){ // не пустой список
        int indexPrize = this.getIndexRandomPrize();
        Toy prize = this.model.actualPresents.postponePrize(indexPrize);
        this.model.writeToFile();
        String prize1 = this.log.setPrize(prize, this.view.getNameWinner());
        this.view.printText("Выигрыш: " + prize1);
    }

    public void givePrize(){
        String prize = this.log.getPrize();
        this.view.printText("Приз получен: " + prize);
    }

    public void increaseCountToy(){
        this.view.printText("> Выберите игрушку и укажите количество " +
                "игрушек для добавления");
        this.view.printPresents(this.model.actualPresents);
        int index = this.view.getIndexToy(this.model.actualPresents.presents);
        int countAdd = this.view.getCountToy();
        this.model.actualPresents.increaseCountToy(index, countAdd);
        this.model.writeToFile();
        this.view.printText("> Количество увеличено");
    }

    public void decreaseCountToy(){
        this.view.printText("> Выберите игрушку и укажите количество игрушек для удаления" +
                "\n> Если останется меньше 1 шт., то игрушка будет удалена из списка");
        this.view.printPresents(this.model.actualPresents);
        int index = this.view.getIndexToy(this.model.actualPresents.presents);
        int countDel = this.view.getCountToy();
        boolean f = this.model.actualPresents.decreaseCountToy(index, countDel);
        this.model.writeToFile();
        if (f) this.view.printText("> Количество уменьшено");
        else this.view.printText("> Игрушка удалена");
    }
    public void changeWeightToy(){
        this.view.printText("> Выберите игрушку и укажите новый вес");
        this.view.printPresents(this.model.actualPresents);
        int index = this.view.getIndexToy(this.model.actualPresents.presents);
        int newWeight = this.view.getWeightToy(1, 99);
        this.model.actualPresents.changeWeightToy(index, newWeight);
        this.model.writeToFile();
        this.view.printText("> Вес изменен");
    }
    public void addToy(){
        this.view.printText("> Добавление новой игрушки");
        this.model.actualPresents.addToy(
                this.view.getNameToy(2),
                this.view.getCountToy(),
                this.view.getWeightToy(1, 99)
        );
        this.model.writeToFile();
        this.view.printText("> Игрушка добавлена");
    }
    public void delToy(){
        this.view.printText("> Выберите игрушку для удаления");
        this.view.printPresents(this.model.actualPresents);
        int index = this.view.getIndexToy(this.model.actualPresents.presents);
        this.model.actualPresents.delToy(index);
        this.model.writeToFile();
        this.view.printText("> Игрушка удалена");
    }
    public void showTotalCountToys(){
        int count = this.model.actualPresents.getTotalCountToys();
        this.view.printText(String.format("> Количество оставшихся призов: %d шт.", count));
    }

    private int getIndexRandomPrize(){
        int[] chances = model.actualPresents.getWeightAll();
        int len = chances.length - 2; // послед элемент (sum)
        int choice = rand.nextInt(1, chances[len + 1] + 1);
        int step = chances[0];
        for (int i = 0; i < len; i++) {
            if (choice <= step) {
                return i;
            } else step += chances[i + 1];
        }
        return len;
    }
}
