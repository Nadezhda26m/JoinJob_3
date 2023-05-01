package config;

import java.io.File;

public class Config {
    public final static String pathDB = getPath();

    private static String getPath(){
        String path = System.getProperty("user.dir")
                + File.separator + "database" + File.separator;
        File file = new File(path);
        file.mkdirs();
        return path;
    }
}
