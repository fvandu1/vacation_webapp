package com.example.task1.dao;

import com.example.task1.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
public interface CartItemsRepository extends JpaRepository<CartItem, Long> {
}
