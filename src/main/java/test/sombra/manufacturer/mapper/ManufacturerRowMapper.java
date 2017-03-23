package test.sombra.manufacturer.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import test.sombra.manufacturer.domain.Manufacturer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan on 23.03.2017.
 */
@Component
public class ManufacturerRowMapper implements RowMapper<Manufacturer> {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String COUNTRY = "country";
    private static final String LOGO = "logo";

    @Override
    public Manufacturer mapRow(ResultSet resultSet, int i) throws SQLException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(resultSet.getLong(ID));
        manufacturer.setName(resultSet.getString(NAME));
        manufacturer.setCountry(resultSet.getString(COUNTRY));
        manufacturer.setLogo(resultSet.getString(LOGO));

        return manufacturer;
    }

    public List<Manufacturer> mapRows(List<Map<String, Object>> rows) {
        List<Manufacturer> manufacturers = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setId((Long) row.get(ID));
            manufacturer.setName((String) row.get(NAME));
            manufacturer.setCountry((String) row.get(COUNTRY));
            manufacturer.setLogo((String) row.get(LOGO));

            manufacturers.add(manufacturer);
        }
        return manufacturers;
    }
}
