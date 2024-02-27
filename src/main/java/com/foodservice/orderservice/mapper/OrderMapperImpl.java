package com.foodservice.orderservice.mapper;

import com.foodservice.orderservice.dto.OrderDTO;
import com.foodservice.orderservice.entity.Order;

public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order mapOrderDTOtoOrder(OrderDTO orderDTO) {
        if (orderDTO == null)
            return null;
        else {
            Order order = new Order();
            order.setOrderId(orderDTO.getOrderId());
            order.setFoodItemsList(orderDTO.getFoodItemsList());
            order.setRestaurant(orderDTO.getRestaurant());
            order.setUserDTO(orderDTO.getUserDTO());

            return order;
        }
    }

    @Override
    public OrderDTO mapOrdertoOrderDTO(Order order) {
        if (order == null)
            return null;
        else {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId(order.getOrderId());
            orderDTO.setFoodItemsList(order.getFoodItemsList());
            orderDTO.setRestaurant(order.getRestaurant());
            orderDTO.setUserDTO(order.getUserDTO());

            return orderDTO;
        }
    }
}
