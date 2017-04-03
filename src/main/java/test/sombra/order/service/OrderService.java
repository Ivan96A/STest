package test.sombra.order.service;


import org.springframework.http.ResponseEntity;
import test.sombra.good.domain.Good;
import test.sombra.order.domain.Order;
import test.sombra.order.domain.OrderDTO;

/**
 * Created by Ivan on 26.03.2017.
 */
public interface OrderService {

    ResponseEntity<Order> findOne(Long id);

    ResponseEntity<Order> addGoodToOrder(OrderDTO orderDTO);

    ResponseEntity<Order> deleteGoodFromOrder(OrderDTO orderDTO);

}
