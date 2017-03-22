package test.sombra.dao;

import java.util.List;

/**
 * Created by Ivan on 22.03.2017.
 */
public interface DAO<T> {

    List<T> findAll();

    int insert(T t);

    int update(T t);

    void delete(Long id);

    T findOneById(Long id);

}
