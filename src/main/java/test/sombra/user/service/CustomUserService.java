package test.sombra.user.service;

import org.springframework.http.ResponseEntity;
import test.sombra.dto.AuthUserDTO;
import test.sombra.dto.LoginUserDTO;
import test.sombra.user.domain.CustomUser;

import java.util.List;

/**
 * Created by Ivan on 24.03.2017.
 */
public interface CustomUserService {

    ResponseEntity<List<CustomUser>> getAll();

    ResponseEntity<CustomUser> getOne(Long id);

    ResponseEntity<CustomUser> getOneByUsername(String username);

    ResponseEntity<CustomUser> save(CustomUser user);

    ResponseEntity<CustomUser> edit(CustomUser user);

    ResponseEntity<Void> delete(Long id);

    ResponseEntity<CustomUser> changeActiveStatus(CustomUser user);

    AuthUserDTO authenticateUser(LoginUserDTO loginUserDTO);

}
