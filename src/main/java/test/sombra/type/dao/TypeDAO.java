package test.sombra.type.dao;

import test.sombra.dao.DAO;
import test.sombra.type.domain.Type;

/**
 * Created by Ivan on 26.03.2017.
 */
public interface TypeDAO extends DAO<Type, Long>{

    Type findOneByName(String name);
}
