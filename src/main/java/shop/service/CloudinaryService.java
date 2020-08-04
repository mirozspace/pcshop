package shop.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

    /**
     * A method for uploading a photo to Cloudinary.
     * Returns string with a link to the already uploaded photo.
     * @param multipartFile
     * @return String
     * @throws IOException
     */
    String uploadImage(MultipartFile multipartFile) throws IOException;

}
