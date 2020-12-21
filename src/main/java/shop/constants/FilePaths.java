package shop.constants;

import java.io.File;

public abstract class FilePaths {

    public static final String DEFAULT_IMAGE_PRODUCT = "https://uc45c61a8df72be3eecf885900e6.dl.dropboxusercontent.com/cd/0/inline/" +
            "BFeHFLlhXEfY-Yu55II9_h5OwlpgxW0Tpa7O4M_wOGWHShTepZEjorcbJcYzJZPeOw_S8pHCwZ0tX22O_Tlqv0hpgnr2yRL3hCrWdWsgVzFatCEIit4YSwzW9phTMShiapE/file#";

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
