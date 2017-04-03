package test.sombra.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.sombra.good.domain.Good;
import test.sombra.order.domain.Order;
import test.sombra.order.domain.OrderDTO;
import test.sombra.order.service.OrderService;

/**
 * Created by Ivan on 31.03.2017.
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Order> addGoodToOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.addGoodToOrder(orderDTO);
    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.POST)
    public ResponseEntity<Order> deleteGoodFromOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.deleteGoodFromOrder(orderDTO);
    }

}
