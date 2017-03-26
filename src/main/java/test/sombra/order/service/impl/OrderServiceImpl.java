package test.sombra.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.sombra.good.domain.Good;
import test.sombra.order.dao.OrderDAO;
import test.sombra.order.dao.impl.OrderDAOImpl;
import test.sombra.order.domain.Order;
import test.sombra.order.service.OrderService;

/**
 * Created by Ivan on 26.03.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAOImpl orderDAOimpl) {
        this.orderDAO = orderDAOimpl;
    }

    @Override
    public int add(Order order) {
        return orderDAO.insert(order);
    }

    @Override
    public Order findOne(Long id) {
        return orderDAO.findOneById(id);
    }

    @Override
    public int addOrderToOrder(Good good, Order order) {
        return orderDAO.addGoodToOrder(good, order);
    }

    @Override
    public void deleteGoodFromOrder(Good good, Order order) {
            orderDAO.deleteGoodFromOrder(good, order);
    }
}
