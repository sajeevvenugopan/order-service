package com.foodservice.orderservice.controller;

import com.foodservice.orderservice.dto.OrderDTO;
import com.foodservice.orderservice.dto.OrderDTOFrontEnd;
import com.foodservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService orderService;

@PostMapping("/saveorder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFrontEnd orderDetails) {
        OrderDTO orderDTO = orderService.saveOrderInDb(orderDetails);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }
}
