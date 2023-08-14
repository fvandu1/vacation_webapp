package com.example.task1.controllers;

import com.example.task1.dao.CustomersRepository;
import com.example.task1.entities.Customer;
import com.example.task1.services.CheckoutServiceImpl;
import com.example.task1.services.CheckoutService;
import com.example.task1.services.PurchaseData;
import jakarta.validation.Valid;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.example.task1.services.PurchaseResponseData;
import org.hibernate.Version;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin("http://localhost:4200")
public class CheckoutController {
    CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {this.checkoutService = checkoutService;}

    @PostMapping("/purchase")
    public PurchaseResponseData placeOrder(@RequestBody PurchaseData purchaseData) {

        return checkoutService.placeOrder(purchaseData);

    }

}
