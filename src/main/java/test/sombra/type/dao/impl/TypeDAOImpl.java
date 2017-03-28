package test.sombra.type.dao.impl;

import com.google.common.base.Strings;
import com.google.common.primitives.Longs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import test.sombra.type.dao.TypeDAO;
import test.sombra.type.domain.Type;
import test.sombra.type.mapper.TypeRowMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Ivan on 23.03.2017.
 */
@Component
public class TypeDAOImpl implements TypeDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeDAOImpl.class);

    private static final String FIND_ALL_QUERY = "SELECT * FROM types";

    private static final String INSERT_QUERY = "INSERT INTO types(name) VALUES(?)";

    private static final String UPDATE_QUERY = "UPDATE types " +
            "SET name = ? WHERE id = ?";

    private static final String DELETE_QUERY = "DELETE FROM types WHERE id = ?";

    private static final String FIND_ONE_BY_ID_QUERY = "SELECT * FROM types " +
            "WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    private final TypeRowMapper typeRowMapper;

    @Autowired
    public TypeDAOImpl(JdbcTemplate jdbcTemplate, TypeRowMapper typeRowMapper) {
        Assert.notNull(jdbcTemplate, "jdbcTemplate must not be null");
        Assert.notNull(typeRowMapper, "rowMapper must not be null");
        this.typeRowMapper = typeRowMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

     @Override
    public List<Type> findAll() {
        LOGGER.info("Finding all rows of types");
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(FIND_ALL_QUERY);
        return typeRowMapper.mapRows(rows);
    }

    @Override
    public int insert(Type type) {
        LOGGER.info("Inserting a new type with name='{}'", type.getName());
        return jdbcTemplate.update(INSERT_QUERY, type.getName());
    }

    @Override
    public int update(Type type) {
        LOGGER.info("Updating a type with id='{}'", type.getId());
        return jdbcTemplate.update(UPDATE_QUERY,
                type.getName(),
                type.getId());
    }

    @Override
    public void delete(Long aLong) {
        LOGGER.info("Deleting a type with id='{}'", aLong);
        jdbcTemplate.update(DELETE_QUERY, aLong);
    }

    @Override
    public Type findOneById(Long aLong) {
        LOGGER.info("Finding a type by id='{}'", aLong);
        return jdbcTemplate.queryForObject(FIND_ONE_BY_ID_QUERY,
                new Object[]{aLong},
                typeRowMapper);
    }
}
