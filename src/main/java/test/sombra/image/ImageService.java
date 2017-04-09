package test.sombra.image;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Ivan on 08.04.2017.
 */
public interface ImageService {

    boolean uploadImage(MultipartFile multipartFile);

}
