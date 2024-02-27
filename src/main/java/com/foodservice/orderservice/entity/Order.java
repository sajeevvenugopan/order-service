package com.foodservice.orderservice.entity;

import com.foodservice.orderservice.dto.FoodItem;
import com.foodservice.orderservice.dto.Restaurant;
import com.foodservice.orderservice.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

    private Integer orderId;
    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
    private UserDTO userDTO;
}
