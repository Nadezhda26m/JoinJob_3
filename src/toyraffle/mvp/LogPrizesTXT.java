package toyraffle.mvp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class LogPrizesTXT extends Model {
    protected Queue<String> prizes = new LinkedList<>();
    public LogPrizesTXT(String path, String fileName) throws IOException {
        super(path, fileName, ".txt");
        if (super.isFile && super.file.length() > 0){
            this.readFile();
        }
    }

    private void readFile(){
        String str;
        try (BufferedReader reader = new BufferedReader(new FileReader(super.file))) {
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty())
                    this.prizes.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setPrize(Toy toy, String nameWinner){
        String s = String.format("id: %d, %s, %s", toy.id, toy.name, nameWinner);
        this.prizes.add(s);
        try (FileWriter logFile = new FileWriter(super.file, true)){
            logFile.write(s + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPrize(){
        String s = this.prizes.remove();
        this.writeToFile();
        return s;
    }

    public void writeToFile(){
        try (FileWriter logFile = new FileWriter(super.file, false)){
            for (String str : this.prizes) {
                logFile.write(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
