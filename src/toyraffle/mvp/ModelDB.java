package toyraffle.mvp;

import java.io.IOException;
import java.util.ArrayList;

public abstract class ModelDB extends Model{
    protected Presents actualPresents = new Presents();

    public ModelDB(String path, String fileName, String extension) throws IOException {
        super(path, fileName, extension);
        if (super.isFile && super.file.length() > 0){
            this.actualPresents.setSourceData(this.readFile());
        }
    }

    public void writeToFile(){
    }

    protected ArrayList<Toy> readFile() {
        return new ArrayList<>();
    }
}
