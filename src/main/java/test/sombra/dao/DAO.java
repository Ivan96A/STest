package test.sombra.dao;

import java.util.List;

/**
 * Created by Ivan on 22.03.2017.
 */
public interface DAO<T, K> {

    List<T> findAll();

    int insert(T t);

    int update(T t);

    void delete(K k);

    T findOneById(K k);

}
