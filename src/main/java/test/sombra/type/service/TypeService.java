package test.sombra.type.service;

import test.sombra.type.domain.Type;

import java.util.List;

/**
 * Created by Ivan on 23.03.2017.
 */
public interface TypeService {

    List<Type> getAll();

    int add(Type type);

    int update(Type type);

    void delete(Long id);

    Type getOne(Long id);
}
