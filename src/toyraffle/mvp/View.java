package toyraffle.mvp;

import java.util.ArrayList;

public interface View {
    String getNameToy(int minCountChars);
    int getCountToy(); // > 0
    int getWeightToy(int minWeight, int maxWeight); // вкл.
    int getIndexToy(ArrayList<Toy> presents); // по id
    String getNameWinner();
    int getIndexCommand(String[] commands);
    void printText(String text);
    void printPresents(Presents presents);
    void printCommands(String[] commands);
    boolean confirmAction();
}
