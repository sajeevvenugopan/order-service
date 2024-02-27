package com.foodservice.orderservice.service;

import com.foodservice.orderservice.dto.OrderDTO;
import com.foodservice.orderservice.dto.OrderDTOFrontEnd;
import com.foodservice.orderservice.dto.UserDTO;
import com.foodservice.orderservice.entity.Order;
import com.foodservice.orderservice.mapper.OrderMapper;
import com.foodservice.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Autowired
    private RestTemplate restTemplate;


    public OrderDTO saveOrderInDb(OrderDTOFrontEnd orderDetails) {

        Integer newOrderId = sequenceGenerator.generatedNextOrderId();
        UserDTO userDTO = fetchUserDetailsWithUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderId,orderDetails.getFoodItemsList(),orderDetails.getRestaurant(),userDTO);

        //To save the details into the MongoDB
        orderRepository.save(orderToBeSaved);

        return OrderMapper.INSTANCE.mapOrdertoOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsWithUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-INFO/user/fetchuserbyid/"+userId, UserDTO.class);
    }
}
