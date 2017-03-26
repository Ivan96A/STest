package test.sombra.manufacturer.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import test.sombra.dao.DAO;
import test.sombra.manufacturer.dao.ManufacturerDAO;
import test.sombra.manufacturer.domain.Manufacturer;
import test.sombra.manufacturer.mapper.ManufacturerRowMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Ivan on 23.03.2017.
 */
@Component
public class ManufacturerDAOImpl implements ManufacturerDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(Manufacturer.class);

    private static final String FIND_ALL_QUERY = "SELECT * FROM manufacturers";

    private static final String INSERT_QUERY = "INSERT INTO manufacturers(name) VALUES(?)";

    private static final String UPDATE_QUERY = "UPDATE manufacturers " +
            "SET name = ? WHERE id = ?";

    private static final String DELETE_QUERY = "DELETE FROM manufacturers WHERE id = ?";

    private static final String FIND_ONE_BY_ID_QUERY = "SELECT * FROM manufacturers " +
            "WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    private final ManufacturerRowMapper manufacturerRowMapper;

    @Autowired
    public ManufacturerDAOImpl(JdbcTemplate jdbcTemplate, ManufacturerRowMapper manufacturerRowMapper) {
        Assert.notNull(jdbcTemplate, "jdbcTemplate must not be null");
        Assert.notNull(manufacturerRowMapper, "rowMapper must not be null");
        this.jdbcTemplate = jdbcTemplate;
        this.manufacturerRowMapper = manufacturerRowMapper;
    }

    @Override
    public List<Manufacturer> findAll() {
        LOGGER.info("finding all rows of manufacturers");
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(FIND_ALL_QUERY);
        return manufacturerRowMapper.mapRows(rows);
    }

    @Override
    public int insert(Manufacturer manufacturer) {
        LOGGER.info("inserting a manufacturer with name='{}'", manufacturer.getName());
        return jdbcTemplate.update(INSERT_QUERY, manufacturer.getName());
    }

    @Override
    public int update(Manufacturer manufacturer) {
        LOGGER.warn("updating a manufacturer with name='{}'", manufacturer.getName());
        return jdbcTemplate.update(UPDATE_QUERY, manufacturer.getName(), manufacturer.getId());
    }

    @Override
    public void delete(Long aLong) {
    LOGGER.info("deleting a manufacturer with id='{}'", aLong);
        jdbcTemplate.update(DELETE_QUERY, aLong);
    }

    @Override
    public Manufacturer findOneById(Long aLong) {
        LOGGER.info("finding a manufacturer by id='{}'", aLong);
        return jdbcTemplate.queryForObject(FIND_ONE_BY_ID_QUERY,
                new Object[]{aLong},
                manufacturerRowMapper
        );
    }
}
