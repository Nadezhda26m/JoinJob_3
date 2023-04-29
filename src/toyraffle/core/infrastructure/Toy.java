package toyraffle.core.infrastructure;

public class Toy {
    protected int id;
    protected String name;
    protected int count;
    protected int weight;

    public Toy(int id, String name, int count, int weight) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.weight = weight;
    }

    protected void increaseCount(int countAdd) {
        this.count += countAdd;
    }

    protected void decreaseCount(int countDel) {
        this.count -= countDel;
        if (this.count < 0) this.count = 0;
    }

    protected void decreaseCount() {
        this.decreaseCount(1);
    }

    protected void changeWeight(int newWeight) { // 1..99
        this.weight = newWeight;
    }

    public int getCount() {
        return count;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("id_%d %s #%d шт. вес = %d%%",
                this.id, this.name, this.count, this.weight);
    }
}

