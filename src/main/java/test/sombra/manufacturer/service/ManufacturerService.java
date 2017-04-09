package test.sombra.manufacturer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import test.sombra.manufacturer.domain.Manufacturer;

import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by Ivan on 23.03.2017.
 */
public interface ManufacturerService {

    ResponseEntity<List<Manufacturer>> getAll();

    ResponseEntity<Manufacturer> add(Manufacturer manufacturer);

    ResponseEntity<Manufacturer> update(Manufacturer manufacturer);

    ResponseEntity<Void> delete(Long id);

    ResponseEntity<Manufacturer> getOne(Long id);

    ResponseEntity<Manufacturer> getOneByName(String name);

    ResponseEntity<String> uploadLogo(MultipartFile multipartFile);
}
