package test.sombra.image.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import test.sombra.image.ImageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Ivan on 08.04.2017.
 */
@Service
public class ImageServiceImpl implements ImageService {

    private static final String UPLOADED_FOLDER = "src//main//webapp//images//";


    @Override
    public boolean uploadImage(MultipartFile multipartFile) {

        try {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
