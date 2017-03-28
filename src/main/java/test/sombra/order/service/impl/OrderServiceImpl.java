package test.sombra.order.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    public OrderServiceImpl(OrderDAOImpl orderDAOimpl) {
        this.orderDAO = orderDAOimpl;
    }

    @Override
    public ResponseEntity<Order> add(Order order) {
        if (order == null) {
            LOGGER.warn("cannot be adding order because order is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orderDAO.insert(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Order> findOne(Long id) {
        if (id <= 0) {
            LOGGER.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderDAO.findOneById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> addOrderToOrder(Good good, Order order) {
        if (good == null || order == null) {
            LOGGER.warn("cannot be added good to order because good or order is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orderDAO.addGoodToOrder(good, order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Order> deleteGoodFromOrder(Good good, Order order) {
        if (good == null || order == null) {
            LOGGER.warn("cannot be deleted good from order because good or order is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orderDAO.deleteGoodFromOrder(good, order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
