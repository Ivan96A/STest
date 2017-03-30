package test.sombra.user.service.impl;

import com.google.common.base.Strings;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import test.sombra.dto.AuthUserDTO;
import test.sombra.dto.LoginUserDTO;
import test.sombra.user.dao.CustomUserDAO;
import test.sombra.user.dao.impl.CustomUserDAOImpl;
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

    private final AuthenticationManager authenticationManager;

    private static final Logger LOGGER = Logger.getLogger(CustomUserServiceImpl.class);


    @Autowired
    public CustomUserServiceImpl(PasswordEncoder passwordEncoder, CustomUserDAO customUserDAO, AuthenticationManager authenticationManager) {
        Assert.notNull(passwordEncoder, "passwordEncoder must not be null");
        Assert.notNull(customUserDAO, "dao must not be null");
        Assert.notNull(authenticationManager, "authenticationManager must not be null");
        this.passwordEncoder = passwordEncoder;
        this.customUserDAO = customUserDAO;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ResponseEntity<List<CustomUser>> getAll() {
        return new ResponseEntity<>(customUserDAO.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomUser> save(CustomUser user) {
        if (user == null) {
            LOGGER.warn("cannot be added user because user is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        user.setActive(true);
        int id = customUserDAO.insert(user);
        user.setId((long) id);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CustomUser> edit(CustomUser user) {
        if (user == null) {
            LOGGER.warn("cannot be edited user because user is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customUserDAO.update(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (id <= 0) {
            LOGGER.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            customUserDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomUser> getOne(Long id) {
        if (id <= 0) {
            LOGGER.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customUserDAO.findOneById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomUser> getOneByUsername(String username) {
        if(Strings.isNullOrEmpty(username)) {
            LOGGER.warn("username cannot be null or empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customUserDAO.findOneByUsername(username), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomUser> changeActiveStatus(CustomUser user) {
        if (user == null) {
            LOGGER.warn("cannot be change status because user is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customUserDAO.changeActiveStatus(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public AuthUserDTO authenticateUser(LoginUserDTO loginUserDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(loginUserDTO.getUsername().trim(), loginUserDTO.getPassword());
        Authentication authentication;
        try {
            authentication = this.authenticationManager.authenticate(authenticationToken);
        } catch (DisabledException e) {
            LOGGER.error("Failed to authenticate : " + loginUserDTO.getUsername(), e);
            return new AuthUserDTO(null, null, null, false, "Disable");
        } catch (BadCredentialsException e) {
            LOGGER.error("Failed to authenticate : " + loginUserDTO.getUsername(), e);
            return new AuthUserDTO(null, null, null, false, "BadCredentials");
        } catch (AccountExpiredException e) {
            LOGGER.error("Failed to authenticate : " + loginUserDTO.getUsername(), e);
            return new AuthUserDTO(null, null, null, false, "AccountExpired");
        } catch (AuthenticationException e) {
            LOGGER.error("Failed to authenticate : " + loginUserDTO.getUsername(), e);
            return new AuthUserDTO(null, null, null, false, "AuthenticationException");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return transformAuthenticationToAuthUserDTO(authentication);
    }

    private AuthUserDTO transformAuthenticationToAuthUserDTO(Authentication authentication) {
        if (authentication == null) {
            return new AuthUserDTO(
                    null,
                    null,
                    null,
                    false,
                    "Failed to obtain authentication, please check your credentials");
        }
        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        CustomUser user = customUserDAO.findOneByUsername(userDetails.getUsername());

        return new AuthUserDTO(user.getUsername(), user.getFirstName(), user.getRole(), user.isActive(), "Success");
    }
}
