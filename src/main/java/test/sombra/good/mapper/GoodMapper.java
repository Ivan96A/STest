package test.sombra.good.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import test.sombra.good.domain.Good;
import test.sombra.manufacturer.dao.ManufacturerDAO;
import test.sombra.manufacturer.dao.impl.ManufacturerDAOImpl;
import test.sombra.manufacturer.domain.Manufacturer;
import test.sombra.manufacturer.service.ManufacturerService;
import test.sombra.type.dao.TypeDAO;
import test.sombra.type.dao.impl.TypeDAOImpl;
import test.sombra.type.domain.Type;
import test.sombra.type.service.TypeService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ivan on 24.03.2017.
 */
@Component
public class GoodMapper implements RowMapper<Good> {

    private static final String ID = "id";

    private static final String PRICE = "price";

    private static final String STATUS = "status";

    private static final String MATERIAL = "material";

    private static final String PICTURE = "picture";

    private static final String TYPE_ID = "type_id";

    private static final String MANUFACTURER_ID = "manufacturer_id";

    private static final String NAME= "name";

    private final TypeDAO typeService;

    private final ManufacturerDAO manufacturerService;

    @Autowired
    public GoodMapper(TypeDAOImpl typeService, ManufacturerDAOImpl manufacturerService) {
        Assert.notNull(typeService, "typeService must not be null");
        Assert.notNull(manufacturerService, "manufacturerService must not be null");
        this.manufacturerService = manufacturerService;
        this.typeService = typeService;
    }

    @Override
    public Good mapRow(ResultSet resultSet, int i) throws SQLException {
        Good good = new Good();
        good.setId(resultSet.getLong(ID));
        good.setPrice(resultSet.getDouble(PRICE));
        good.setStatus(resultSet.getBoolean(STATUS));
        good.setMaterial(resultSet.getString(MATERIAL));
        good.setPicture(resultSet.getString(PICTURE));

        Manufacturer manufacturer = manufacturerService.findOneById(resultSet.getLong(MANUFACTURER_ID));
        Type type = typeService.findOneById(resultSet.getLong(TYPE_ID));

        good.setManufacturer(manufacturer);
        good.setType(type);
        good.setName(resultSet.getString(NAME));
        return good;
    }

    public List<Good> mapRows(List<Map<String, Object>> rows) {
        List<Good> goods = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Good good = new Good();

            good.setId((Long) row.get(ID));
            good.setPrice((Double) row.get(PRICE));
            good.setStatus((Boolean) row.get(STATUS));
            good.setMaterial((String) row.get(MATERIAL));
            good.setPicture((String) row.get(PICTURE));

            Manufacturer manufacturer = manufacturerService.findOneById((Long) row.get(MANUFACTURER_ID));
            Type type = typeService.findOneById((Long) row.get(TYPE_ID));

            good.setManufacturer(manufacturer);
            good.setType(type);
            good.setName((String) row.get(NAME));
            goods.add(good);
        }

        return goods;
    }
}
