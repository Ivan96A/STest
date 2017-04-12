package test.sombra.order.dao.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import test.sombra.good.domain.Good;
import test.sombra.order.dao.OrderDAO;
import test.sombra.order.domain.Order;
import test.sombra.order.mapper.OrderMapper;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Ivan on 26.03.2017.
 */
@Component
public class OrderDAOImpl implements OrderDAO {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OrderDAOImpl.class);

    private static final String INSERT_QUERY = "INSERT INTO orders(user_id) " +
            "VALUES(?)";

    private static final String FIND_ONE_BY_ID_QUERY = "SELECT * FROM orders WHERE id = ?";

    private static final String INSERT_GOOD_TO_ORDER = "INSERT INTO goods_orders " +
            "VALUES(?,?)";

    private static final String DELETE_GOOD_FROM_ORDER = "DELETE FROM goods_orders " +
            "WHERE goods_id = ? AND orders_user_id = ?";

    private static final String FIND_COUNT_BY_USER_ID_QUERY = "SELECT COUNT(user_id) FROM orders WHERE user_id = ?";

    private static final String FIND_ONE_BY_USER_ID_QUERY = "SELECT * FROM orders WHERE user_id = ?";

    private final JdbcTemplate jdbcTemplate;

    private final OrderMapper orderMapper;

    @Autowired
    public OrderDAOImpl(JdbcTemplate jdbcTemplate, OrderMapper orderMapper) {
        Assert.notNull(jdbcTemplate, "jdbcTemplate must not be null");
        Assert.notNull(orderMapper, "orderMapper must not be null");
        this.jdbcTemplate = jdbcTemplate;
        this.orderMapper = orderMapper;
    }

    @Override
    @Deprecated
    public List<Order> findAll() {
        return null;
    }

    @Override
    public int insert(Order order) {
        LOGGER.info("inserting an order");
        return jdbcTemplate.update(INSERT_QUERY,
                order.getUser().getId()
        );
    }

    @Override
    @Deprecated
    public int update(Order order) {
        return 0;
    }

    @Override
    @Deprecated
    public void delete(Long aLong) {

    }

    @Override
    public Order findOneById(Long aLong) {
        LOGGER.info("finding an order with id='{}'", aLong);
        return jdbcTemplate.queryForObject(FIND_ONE_BY_ID_QUERY,
                new Object[]{aLong},
                orderMapper
        );
    }

    @Override
    public int addGoodToOrder(Good good, Order order) {
        LOGGER.info("adding good with id='{}' to order with id='{}'", good.getId(),
                order.getUser().getId());
        return jdbcTemplate.update(INSERT_GOOD_TO_ORDER,
                good.getId(),
                order.getUser().getId());
    }

    @Override
    public void deleteGoodFromOrder(Good good, Order order) {
        LOGGER.info("deleting good with id='{}' from order with id='{}'", good.getId(),
                order.getId());
        jdbcTemplate.update(DELETE_GOOD_FROM_ORDER,
                good.getId(),
                order.getUser().getId());
    }

    @Override
    public Long findCountRowsByUserId(Long id) {
        LOGGER.info("finding count rows by userId");
        Long count = jdbcTemplate.queryForObject(FIND_COUNT_BY_USER_ID_QUERY, Long.class, new Object[]{id});
        if (count == null) return null;
        else return count;
    }

    @Override
    public Order findOneByUserId(Long id) {
        LOGGER.info("finding order by user_id");
        return jdbcTemplate.queryForObject(FIND_ONE_BY_USER_ID_QUERY, new Object[]{id}, orderMapper);
    }
}
