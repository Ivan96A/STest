package test.sombra.user.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import test.sombra.user.domain.CustomUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan on 23.03.2017.
 */
@Component
public class CustomUserMapper implements RowMapper<CustomUser>{

    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String ACTIVE = "active";
    private static final String ROLE = "role";

    @Override
    public CustomUser mapRow(ResultSet resultSet, int i) throws SQLException {

        CustomUser user = new CustomUser();
        user.setId(resultSet.getLong(ID));
        user.setFirstName(resultSet.getString(FIRST_NAME));
        user.setLastName(resultSet.getString(LAST_NAME));
        user.setUsername(resultSet.getString(USERNAME));
        user.setPassword(resultSet.getString(PASSWORD));
        user.setActive(resultSet.getBoolean(ACTIVE));
        user.setRole(resultSet.getString(ROLE));

        return user;
    }

    public List<CustomUser> mapRows(List<Map<String, Object>> rows) {
        List<CustomUser> users = new ArrayList<>();
        for(Map<String, Object> row: rows) {
            CustomUser user = new CustomUser();
            user.setId((Long) row.get(ID));
            user.setFirstName((String) row.get(FIRST_NAME));
            user.setLastName((String) row.get(LAST_NAME));
            user.setUsername((String) row.get(USERNAME));
            user.setPassword((String) row.get(PASSWORD));
            user.setActive((Boolean) row.get(ACTIVE));
            user.setRole((String) row.get(ROLE));

            users.add(user);
        }

        return users;
    }

}
