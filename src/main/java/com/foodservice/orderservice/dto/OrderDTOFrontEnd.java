package com.foodservice.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFrontEnd {

    private List<FoodItem> foodItemsList;
    private Integer userId;
    private Restaurant restaurant;
}
