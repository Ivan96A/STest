package test.sombra.user.service;

import test.sombra.user.domain.CustomUser;

import java.util.List;

/**
 * Created by Ivan on 24.03.2017.
 */
public interface CustomUserService {

    List<CustomUser> getAll();

    CustomUser getOne(Long id);

    CustomUser getOneByUsername(String username);

    CustomUser save(CustomUser user);

    CustomUser edit(CustomUser user);

    void delete(Long id);

    CustomUser changeActiveStatus(CustomUser user);

}
