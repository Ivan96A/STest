package test.sombra.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.sombra.dto.AuthUserDTO;
import test.sombra.dto.LoginUserDTO;
import test.sombra.user.domain.CustomUser;
import test.sombra.user.service.CustomUserService;

import java.util.List;

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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CustomUser>> getAll() {
        return customUserService.getAll();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<CustomUser> findOne(@PathVariable("id") Long id) {
        return customUserService.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CustomUser> update(@RequestBody CustomUser user) {
        return customUserService.edit(user);
    }

}
