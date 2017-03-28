package test.sombra.order.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import test.sombra.good.dao.GoodDAO;
import test.sombra.good.dao.impl.GoodDAOImpl;
import test.sombra.good.domain.Good;
import test.sombra.good.service.GoodService;
import test.sombra.order.domain.Order;
import test.sombra.user.dao.CustomUserDAO;
import test.sombra.user.dao.impl.CustomUserDAOImpl;
import test.sombra.user.domain.CustomUser;
import test.sombra.user.service.CustomUserService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ivan on 26.03.2017.
 */
@Component
public class OrderMapper implements RowMapper<Order> {

    private static final String ID = "id";

    private static final String AMOUNT = "amount";

    private static final String USER_ID = "user_id";

    private final GoodDAO goodService;

    private final CustomUserDAO customUserService;

    @Autowired
    public OrderMapper(GoodDAOImpl goodService, CustomUserDAOImpl customUserService) {
        Assert.notNull(goodService, "goodService must not be null");
        Assert.notNull(customUserService, "customUserService must not be null");
        this.goodService = goodService;
        this.customUserService = customUserService;
    }

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();

        order.setId(resultSet.getLong(ID));
        order.setAmount(resultSet.getDouble(AMOUNT));
        CustomUser user = customUserService.findOneById(resultSet.getLong(USER_ID));
        order.setUser(user);
        List<Good> goods = goodService.findAllByOrderId(order.getId());
        order.setGoods(new HashSet<>(goods));

        return order;
    }
}
