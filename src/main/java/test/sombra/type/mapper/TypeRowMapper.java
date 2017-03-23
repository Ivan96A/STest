package test.sombra.type.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import test.sombra.type.domain.Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan on 22.03.2017.
 */

@Component
public class TypeRowMapper implements RowMapper<Type> {

    private static final String ID = "id";

    private static final String NAME = "name";

    @Override
    public Type mapRow(ResultSet resultSet, int i) throws SQLException {
        Type type = new Type();
        type.setId(resultSet.getLong(ID));
        type.setName(resultSet.getString(NAME));

        return type;
    }

    public List<Type> mapRows(List<Map<String, Object>> rows) {
        List<Type> types = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Type type = new Type();
            type.setId((Long) row.get(ID));
            type.setName((String) row.get(NAME));

            types.add(type);
        }
        return types;
    }
}
