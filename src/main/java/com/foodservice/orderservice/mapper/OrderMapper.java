package com.foodservice.orderservice.mapper;

import com.foodservice.orderservice.dto.OrderDTO;
import com.foodservice.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOtoOrder(OrderDTO orderDTO);
    OrderDTO mapOrdertoOrderDTO(Order order);
}
