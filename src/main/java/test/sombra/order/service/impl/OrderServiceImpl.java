package test.sombra.order.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import test.sombra.good.dao.GoodDAO;
import test.sombra.good.domain.Good;
import test.sombra.good.service.GoodService;
import test.sombra.order.dao.OrderDAO;
import test.sombra.order.dao.impl.OrderDAOImpl;
import test.sombra.order.domain.Order;
import test.sombra.order.domain.OrderDTO;
import test.sombra.order.service.OrderService;
import test.sombra.user.dao.CustomUserDAO;
import test.sombra.user.domain.CustomUser;

/**
 * Created by Ivan on 26.03.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    private final CustomUserDAO customUserDAO;

    private final GoodDAO goodDao;

    private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    public OrderServiceImpl(OrderDAOImpl orderDAOimpl, CustomUserDAO customUserDAO, GoodDAO goodDAO) {
        this.orderDAO = orderDAOimpl;
        this.customUserDAO = customUserDAO;
        this.goodDao = goodDAO;
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
    public ResponseEntity<Order> addGoodToOrder(OrderDTO orderDTO) {
        if (orderDTO == null) {
            LOGGER.warn("cannot be added good to order because orderDTO is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Good good = goodDao.findOneById(orderDTO.getGoodId());
        CustomUser customUser = customUserDAO.findOneByUsername(orderDTO.getUsername());
        Order order;
        if (orderDAO.findCountRowsByUserId(customUser.getId()) == 0) {
            order = new Order();
            order.setUser(customUser);
            orderDAO.insert(order);
        }
        order = orderDAO.findOneByUserId(customUser.getId());
        orderDAO.addGoodToOrder(good, order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Order> deleteGoodFromOrder(OrderDTO orderDTO) {
        if (orderDTO == null) {
            LOGGER.warn("cannot be deleted good from order because good or orderDTO is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Good good = goodDao.findOneById(orderDTO.getGoodId());
        Order order = orderDAO.findOneByUserId(customUserDAO.findOneByUsername(orderDTO.getUsername()).getId());
        orderDAO.deleteGoodFromOrder(good, order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
