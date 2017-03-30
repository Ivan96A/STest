package test.sombra.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.sombra.dto.AuthUserDTO;
import test.sombra.dto.LoginUserDTO;
import test.sombra.user.domain.CustomUser;
import test.sombra.user.service.CustomUserService;

/**
 * Created by Ivan on 30.03.2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final CustomUserService customUserService;

    @Autowired
    public UserController(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }

    @RequestMapping(
            value = "/public/login",
            method = RequestMethod.POST)
    public AuthUserDTO login(@RequestBody LoginUserDTO loginUserDTO) {
        return customUserService.authenticateUser(loginUserDTO);
    }

    @RequestMapping(value = "/public/register",
            method = RequestMethod.POST)
    public ResponseEntity<CustomUser> register(@RequestBody CustomUser user) {
        return customUserService.save(user);
    }
}
