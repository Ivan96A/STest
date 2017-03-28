package test.sombra.user.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import test.sombra.user.dao.CustomUserDAO;
import test.sombra.user.dao.impl.CustomUserDAOImpl;
import test.sombra.user.domain.CustomUser;
import test.sombra.user.service.CustomUserService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ivan on 27.03.2017.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(UserDetailServiceImpl.class);

    @Autowired
    private CustomUserDAO customUserDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser customUser = customUserDAO.findOneByUsername(username);
        User user;
        if(customUser == null) {
            throw new BadCredentialsException(username);
        }
        final Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(customUser.getRole()));
        user = new User(customUser.getUsername(), customUser.getPassword(), authorities);
        return user;
    }
}
