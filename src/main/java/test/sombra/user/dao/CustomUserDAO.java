package test.sombra.user.dao;

import test.sombra.dao.DAO;
import test.sombra.user.domain.CustomUser;

/**
 * Created by Ivan on 26.03.2017.
 */
public interface CustomUserDAO extends DAO<CustomUser, Long> {

    CustomUser findOneByUsername(String username);

    int changeActiveStatus(CustomUser user);

}
