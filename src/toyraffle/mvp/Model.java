package toyraffle.mvp;

import java.io.File;
import java.io.IOException;

public abstract class Model {
    protected File file;
    protected boolean isFile = true;

    public Model(String path, String fileName, String extension) throws IOException {
        this.file = new File(path + fileName + extension);
        this.checkFile();
    }

    private void checkFile() throws IOException {
        if (!this.file.exists()) {
            if (!this.file.createNewFile()) {
                this.isFile = false;
            }
        }
    }
}