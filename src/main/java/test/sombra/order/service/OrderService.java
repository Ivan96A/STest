package test.sombra.order.service;


import test.sombra.good.domain.Good;
import test.sombra.order.domain.Order;

/**
 * Created by Ivan on 26.03.2017.
 */
public interface OrderService {

    int add(Order order);

    Order findOne(Long id);

    int addOrderToOrder(Good good, Order order);

    void deleteGoodFromOrder(Good good, Order order);

}
