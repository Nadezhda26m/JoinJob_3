package config;

import java.io.File;
import java.nio.file.Paths;

public class Config {
    public final static String pathDB = getPath();

    private static String getPath(){
        String path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator + "database" + File.separator;
        File file = new File(path);
        file.mkdirs();
        return path;

        // // Path.of("src/config.Config.java").toAbsolutePath().getParent().toString();
        // String path = Paths.get("src" + File.separator + "config.Config.java")
        //         .toAbsolutePath()
        //         .getParent()
        //         .toString();
        // path += File.separator + "database";
        // File file = new File(path);
        // file.mkdirs();
        // return file.getAbsolutePath() + File.separator;
    }
}
