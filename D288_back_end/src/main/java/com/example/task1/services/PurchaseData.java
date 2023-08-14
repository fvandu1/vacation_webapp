package com.example.task1.services;

import com.example.task1.entities.Cart;
import com.example.task1.entities.CartItem;
import com.example.task1.entities.Customer;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PurchaseData {

    private Customer customer;

    private Cart cart;

    private Set<CartItem> cartItems = new HashSet<>();

}
