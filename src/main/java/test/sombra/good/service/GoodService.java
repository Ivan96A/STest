package test.sombra.good.service;

import org.springframework.http.ResponseEntity;
import test.sombra.good.domain.Good;
import test.sombra.good.domain.GoodDTO;

import java.util.List;

/**
 * Created by Ivan on 25.03.2017.
 */
public interface GoodService {

    ResponseEntity<List<Good>> getAll();

    ResponseEntity<Good> add(Good good);

    ResponseEntity<GoodDTO> getGoodDTOByUsername(String username);

    ResponseEntity<Good> edit(Good good);

    ResponseEntity<Void> delete(Long id);

    ResponseEntity<Good> getOne(Long id);

    ResponseEntity<List<Good>> getAllByName(String name);

    ResponseEntity<List<Good>> getAllByTypeId(String typeName);

    ResponseEntity<List<Good>> getAllByNameAndTypeId(String name, String typeName);
}
