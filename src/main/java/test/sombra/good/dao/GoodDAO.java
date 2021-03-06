package test.sombra.good.dao;

import test.sombra.dao.DAO;
import test.sombra.good.domain.Good;

import java.util.List;

/**
 * Created by Ivan on 26.03.2017.
 */
public interface GoodDAO extends DAO<Good, Long> {

    List<Long> findAllGoodsIdByOrderId(Long id);

    List<Good> findAllByName(String name);

    List<Good> findAllByTypeId(Long id);

    List<Good> findAllByNameAndTypeId(String name, Long id);
}
