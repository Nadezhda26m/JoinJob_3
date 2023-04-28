package toyraffle.core.infrastructure;

import java.util.ArrayList;

public class Presents {
    protected ArrayList<Toy> presents;
    protected int size;
    protected int id;

    public Presents() {
        this.presents = new ArrayList<>();
        this.size = 0;
        this.id = 1;
    }

    protected void addToy(String nameToy, int countToy, int weightToy) {
        // Одинаковые игрушки заносятся с разным id (разные партии),
        // при добавлении той же партии следует менять количество
        this.presents.add(new Toy(this.id++, nameToy, countToy, weightToy));
        this.size += 1;
    }

    protected void delToy(int index) {
        this.presents.remove(index);
        this.size -= 1;
    }

    protected void increaseCountToy(int index, int countAdd) { // index is valid
        this.presents.get(index).increaseCount(countAdd);
    }

    protected void decreaseCountToy(int index, int countDel) {
        this.presents.get(index).decreaseCount(countDel);
        if (this.presents.get(index).count == 0)
            this.delToy(index);
    }

    protected int getTotalCountToys() {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            count += this.presents.get(i).count;
        }
        return count;
    }

    protected void changeWeightToy(int index, int newWeight){
        this.presents.get(index).changeWeight(newWeight);
    }

    protected Toy postponePrize(int index) { // отложить призовую игрушку
        this.presents.get(index).decreaseCount(); // -1
        Toy toy = this.presents.get(index);
        if (toy.count == 0)
            this.delToy(index);
        return toy;
    }

    protected int findIndex(int idToy) {
        for (int i = 0; i < this.size; i++) {
            if (this.presents.get(i).id == idToy) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            s.append(this.presents.get(i).toString()).append("\n");
        }
        return s.toString();
    }
}
