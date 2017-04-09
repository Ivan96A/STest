package test.sombra.type.service;

import org.springframework.http.ResponseEntity;
import test.sombra.type.domain.Type;

import java.util.List;

/**
 * Created by Ivan on 23.03.2017.
 */
public interface TypeService {

    ResponseEntity<List<Type>> getAll();

    ResponseEntity<Type> add(Type type);

    ResponseEntity<Type> update(Type type);

    ResponseEntity<Void> delete(Long id);

    ResponseEntity<Type> getOne(Long id);

    ResponseEntity<Type> getOneByName(String name);
}
