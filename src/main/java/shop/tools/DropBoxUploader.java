/*
package shop.tools;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.users.FullAccount;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DropBoxUploader {

    private static final String ACCESS_TOKEN = "sl.Aet2WfGhjLSaWAClvwXRUVGjpFGGs6VCwnkaTw0ycBPWjFMcYFil" +
            "dVsrl0lS1HU4QMtWu-6NhQUmuG9L2AEktbkm6fYBLl1PkDY_jfR5w62ibVD_pbGdZ41RVq2aw9GM6drTCs0";

    public DropBoxUploader() {
    }

    public String uploadPhotoToDropbox() throws DbxException, IOException {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());

        try (InputStream in = new FileInputStream("C:\\Users\\pcl17\\IdeaProjects\\shop\\src\\main\\resources\\static\\img\\product.png")) {
            FileMetadata metadata = client.files().uploadBuilder("/product.png")
                    .uploadAndFinish(in);
        }
        return null;
    }


}
*/
