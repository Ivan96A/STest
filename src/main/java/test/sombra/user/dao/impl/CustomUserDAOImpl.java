package test.sombra.user.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import test.sombra.user.dao.CustomUserDAO;
import test.sombra.user.domain.CustomUser;
import test.sombra.user.mapper.CustomUserMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Ivan on 24.03.2017.
 */
@Component
public class CustomUserDAOImpl implements CustomUserDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDAOImpl.class);

    private static final String FIND_ALL_QUERY = "SELECT * FROM users";

    private static final String INSERT_QUERY = "INSERT INTO users(first_name, last_name, " +
            "username, password, active, role) " +
            "VALUES(?,?,?,?,?,?)";

    private static final String UPDATE_QUERY = "UPDATE users " +
            "SET first_name = ?, last_name = ?, " +
            "username = ?, active = ?, role = ?  WHERE id = ?";

    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?";

    private static final String FIND_ONE_BY_ID_QUERY = "SELECT * FROM users " +
            "WHERE id = ?";

    private static final String FIND_ONE_BY_USERNAME_QUERY = "SELECT * FROM users " +
            "WHERE username = ?";

    private static final String CHANGE_ACTIVE_STATUS_QUERY = "UPDATE users SET " +
            "active = ? WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    private final CustomUserMapper mapper;

    @Autowired
    public CustomUserDAOImpl(JdbcTemplate jdbcTemplate, CustomUserMapper mapper) {
        Assert.notNull(jdbcTemplate, "jdbcTemplate must not be null");
        Assert.notNull(mapper, "mapper must not be null");
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }


    @Override
    public List<CustomUser> findAll() {
        LOGGER.info("finding all rows of users");
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(FIND_ALL_QUERY);
        return mapper.mapRows(rows);
    }

    @Override
    public int insert(CustomUser customUser) {
        LOGGER.info("inserting a new user with username='{}'", customUser.getUsername());
        return jdbcTemplate.update(INSERT_QUERY,
                customUser.getFirstName(),
                customUser.getLastName(),
                customUser.getUsername(),
                customUser.getPassword(),
                customUser.isActive(),
                customUser.getRole()
        );
    }

    @Override
    public int update(CustomUser customUser) {
        LOGGER.info("updating a user with id='{}'", customUser.getId());
        return jdbcTemplate.update(UPDATE_QUERY,
                customUser.getFirstName(),
                customUser.getLastName(),
                customUser.getUsername(),
                customUser.isActive(),
                customUser.getRole(),
                customUser.getId()
        );
    }

    @Override
    public void delete(Long aLong) {
        LOGGER.info("delete a user with id='{}'", aLong);
        jdbcTemplate.update(DELETE_QUERY, aLong);
    }

    @Override
    public CustomUser findOneById(Long aLong) {
        LOGGER.info("finding a user with id='{}'", aLong);
        return jdbcTemplate.queryForObject(FIND_ONE_BY_ID_QUERY,
                new Object[]{aLong},
                mapper
        );
    }

    @Override
    public CustomUser findOneByUsername(String username) {
        LOGGER.info("finding a user with username='{}'", username);
        return jdbcTemplate.queryForObject(FIND_ONE_BY_USERNAME_QUERY,
                new Object[]{username},
                mapper
        );
    }

    @Override
    public int changeActiveStatus(CustomUser user) {
        LOGGER.info("changing a status of a user with id='{}'", user.getId());
        return jdbcTemplate.update(CHANGE_ACTIVE_STATUS_QUERY,
                user.isActive(),
                user.getId());
    }
}
