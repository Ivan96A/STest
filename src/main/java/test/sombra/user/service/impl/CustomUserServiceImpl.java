package test.sombra.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import test.sombra.user.dao.CustomUserDAO;
import test.sombra.user.domain.CustomUser;
import test.sombra.user.service.CustomUserService;

import java.util.List;

/**
 * Created by Ivan on 24.03.2017.
 */
@Service
public class CustomUserServiceImpl implements CustomUserService {

    private final CustomUserDAO customUserDAO;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomUserServiceImpl(PasswordEncoder passwordEncoder, CustomUserDAO customUserDAO) {
        Assert.notNull(passwordEncoder, "passwordEncoder must not be null");
        Assert.notNull(customUserDAO, "dao must not be null");
        this.passwordEncoder = passwordEncoder;
        this.customUserDAO = customUserDAO;
    }

    @Override
    public List<CustomUser> getAll() {
        return customUserDAO.findAll();
    }

    @Override
    public CustomUser save(CustomUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int id = customUserDAO.insert(user);
        user.setId((long) id);
        return user;
    }

    @Override
    public CustomUser edit(CustomUser user) {
        customUserDAO.update(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        customUserDAO.delete(id);
    }

    @Override
    public CustomUser getOne(Long id) {
        return customUserDAO.findOneById(id);
    }

    @Override
    public CustomUser getOneByUsername(String username) {
        return customUserDAO.findOneByUsername(username);
    }

    @Override
    public CustomUser changeActiveStatus(CustomUser user) {
        customUserDAO.changeActiveStatus(user);
        return user;
    }
}
