package test.sombra.order.service;


import org.springframework.http.ResponseEntity;
import test.sombra.good.domain.Good;
import test.sombra.order.domain.Order;

/**
 * Created by Ivan on 26.03.2017.
 */
public interface OrderService {

    ResponseEntity<Order> add(Order order);

    ResponseEntity<Order> findOne(Long id);

    ResponseEntity<Order> addOrderToOrder(Good good, Order order);

    ResponseEntity<Order> deleteGoodFromOrder(Good good, Order order);

}
