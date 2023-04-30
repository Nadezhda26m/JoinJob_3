package toyraffle.mvp.modeldb;
import toyraffle.mvp.ModelDB;
import toyraffle.mvp.Toy;
import java.util.ArrayList;

public class ModelJSON extends ModelDB {
    public ModelJSON(String path, String fileName) throws Exception{
        super(path, fileName, ".json");
    }

    @Override
    public void writeToFile() {
    }

    @Override
    protected ArrayList<Toy> readFile(){
        return super.readFile();
    }
}
