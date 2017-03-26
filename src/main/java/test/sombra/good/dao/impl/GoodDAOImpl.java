package test.sombra.good.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import test.sombra.good.dao.GoodDAO;
import test.sombra.good.domain.Good;
import test.sombra.good.mapper.GoodMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Ivan on 24.03.2017.
 */
@Component
public class GoodDAOImpl implements GoodDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodDAOImpl.class);

    private static final String FIND_ALL_QUERY = "SELECT * FROM good";

    private static final String INSERT_QUERY = "INSERT INTO good(price, status, " +
            "material, picture, type_id, manufacturer_id) VALUES(?,?,?,?,?,?)";

    private static final String UPDATE_QUERY = "UPDATE good " +
            "SET price = ?, status = ?, material = ?, picture = ?, " +
            "type_id = ?, manufacturer_id = ? WHERE id = ?";

    private static final String DELETE_QUERY = "DELETE FROM good WHERE id = ?";

    private static final String FIND_ONE_BY_ID_QUERY = "SELECT * FROM good " +
            "WHERE id = ?";

    private static final String FIND_ALL_BY_ORDER_ID_QUERY = "SELECT goods_id FROM goods_orders WHERE orders_user_id = ?";

    private final JdbcTemplate jdbcTemplate;

    private final GoodMapper goodMapper;

    @Autowired
    public GoodDAOImpl(JdbcTemplate jdbcTemplate, GoodMapper goodMapper) {
        Assert.notNull(jdbcTemplate, "jdbcTemplate must not be null");
        Assert.notNull(goodMapper, "goodMapper must not be null");

        this.jdbcTemplate = jdbcTemplate;
        this.goodMapper = goodMapper;
    }

    @Override
    public List<Good> findAll() {
        LOGGER.info("finding all rows of goods");
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(FIND_ALL_QUERY);
        return goodMapper.mapRows(rows);
    }

    @Override
    public int insert(Good good) {
        LOGGER.info("inserting a good with id='{}'", good.getId());
        return jdbcTemplate.update(INSERT_QUERY,
                good.getPrice(),
                good.isStatus(),
                good.getMaterial(),
                good.getPicture(),
                good.getType().getId(),
                good.getManufacturer().getId()
        );
    }

    @Override
    public int update(Good good) {
        LOGGER.info("updating a good with id='{}'", good.getId());
        return jdbcTemplate.update(UPDATE_QUERY,
                good.getPrice(),
                good.isStatus(),
                good.getMaterial(),
                good.getPicture(),
                good.getType().getId(),
                good.getManufacturer().getId(),
                good.getId()
        );
    }

    @Override
    public void delete(Long aLong) {
        LOGGER.info("deleting a good with id='{}'", aLong);
        jdbcTemplate.update(DELETE_QUERY, aLong);
    }

    @Override
    public Good findOneById(Long aLong) {
        LOGGER.info("finding a good with id='{}'", aLong);
        return jdbcTemplate.queryForObject(FIND_ONE_BY_ID_QUERY,
                new Object[]{aLong},
                goodMapper
        );
    }

    @Override
    public List<Good> findAllByOrderId(Long id) {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(FIND_ALL_BY_ORDER_ID_QUERY, id);
        return goodMapper.mapRows(rows);
    }

}
