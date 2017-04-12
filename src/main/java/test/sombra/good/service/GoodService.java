package test.sombra.good.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import test.sombra.good.domain.Good;
import test.sombra.good.domain.GoodDTO;

import java.util.List;

/**
 * Created by Ivan on 25.03.2017.
 */
public interface GoodService {

    ResponseEntity<List<Good>> getAll();

    ResponseEntity<Good> add(Good good, String typeName, String manufacturerName);

    ResponseEntity<GoodDTO> getGoodDTOByUsername(String username);

    ResponseEntity<Good> edit(Good good, String typeName, String manufacturerName);

    ResponseEntity<Void> delete(Long id);

    ResponseEntity<Good> getOne(Long id);

    ResponseEntity<List<Good>> getAllByName(String name);

    ResponseEntity<List<Good>> getAllByTypeName(String typeName);

    ResponseEntity<List<Good>> getAllByNameAndTypeId(String name, String typeName);

    ResponseEntity<String> uploadImage(MultipartFile multipartFile);
}
