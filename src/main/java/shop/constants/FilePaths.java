package shop.constants;

import java.io.File;

public abstract class FilePaths {

    public static final String FILE_LOG_PATH = getBaseFilePathString() + "fileLogRequestInterceptor.txt";

    private static String getBaseFilePathString() {
        return System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "resources"
                + File.separator + "static"
                + File.separator + "files"
                + File.separator;
    }
}
