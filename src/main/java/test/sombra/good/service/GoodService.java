package test.sombra.good.service;

import test.sombra.good.domain.Good;

import java.util.List;

/**
 * Created by Ivan on 25.03.2017.
 */
public interface GoodService {

    List<Good> getAll();

    int add(Good good);

    List<Good> getAllByOrderId(Long id);

    int edit(Good good);

    void delete(Long id);

    Good getOne(Long id);
}
