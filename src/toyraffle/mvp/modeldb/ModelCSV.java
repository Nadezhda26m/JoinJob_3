package toyraffle.mvp.modeldb;

import toyraffle.mvp.ModelDB;
import toyraffle.mvp.Toy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ModelCSV extends ModelDB {
    private final StringBuilder header = new StringBuilder();

    public ModelCSV(String path, String fileName) throws IOException {
        super(path, fileName, ".csv");
        this.header.append("id").append(";")
                .append("name").append(";")
                .append("count").append(";")
                .append("weight").append("\n");
    }

    @Override
    public void writeToFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.header);
        for (Toy toy : super.actualPresents.getPresents()) {
            sb.append(toy.getId()).append(";")
                    .append(toy.getName()).append(";")
                    .append(toy.getCount()).append(";")
                    .append(toy.getWeight()).append("\n");
        }
        try (FileWriter dbFile = new FileWriter(super.file, false)) {
            dbFile.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected ArrayList<Toy> readFile() {
        ArrayList<String> list = this.getData();
        ArrayList<Toy> presents = new ArrayList<>();
        String[] toy;
        int size = list.size();
        for (int i = 1; i < size; i++) {
            toy = list.get(i).split(";");
            presents.add(new Toy(Integer.parseInt(toy[0]),
                    toy[1], Integer.parseInt(toy[2]),
                    Integer.parseInt(toy[3])));
        }
        return presents;
    }

    private ArrayList<String> getData() {
        String str;
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(super.file))) {
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) {
                    list.add(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
