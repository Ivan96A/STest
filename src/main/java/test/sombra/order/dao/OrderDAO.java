package test.sombra.order.dao;

import test.sombra.dao.DAO;
import test.sombra.good.domain.Good;
import test.sombra.order.domain.Order;

/**
 * Created by Ivan on 26.03.2017.
 */
public interface OrderDAO extends DAO<Order, Long> {

    int addGoodToOrder(Good good, Order order);

    void deleteGoodFromOrder(Good good, Order order0);
}
