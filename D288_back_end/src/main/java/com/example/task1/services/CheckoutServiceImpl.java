package com.example.task1.services;

import com.example.task1.entities.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.example.task1.dao.CustomersRepository;
import com.example.task1.entities.Cart;
import com.example.task1.entities.Customer;

import java.time.ZoneId;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.Set;

import java.time.LocalDateTime;


@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomersRepository customersRepository;

    public CheckoutServiceImpl(CustomersRepository customerRepository) {
        this.customersRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponseData placeOrder(PurchaseData purchaseData) {

        //Get cart from purchase data
        Cart cart = purchaseData.getCart();

        //Get cart items from purchase data
        Set<CartItem> cartItems = purchaseData.getCartItems();

        //create tracking number
        String trackingNumber = UUID.randomUUID().toString();

        //Set cart tracking number
        cart.setOrderTrackingNumber(trackingNumber);

        //Get customer from cart
        Customer customer = cart.getCustomer();
        Customer dbCustomer = customersRepository.findByIdCustom(customer.getId());

        if (customer.getId().equals(dbCustomer.getId())) {
            customer = dbCustomer;
        }

        //Set create date on cart cart items and customer
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        cart.setCreate_date(date);

        for (CartItem item : cartItems) {
            item.setCreate_date(date);
            item.setLast_update(date);
            cart.getCartItem().add(item);
            item.setCart(cart);
            item.getExcursions().forEach(x -> x.setVacation(item.getVacation()));
        }

        //Set last update on cart.
        cart.setLast_update(date);

        //Add cart to customer
        customer.getCarts().add(cart);

        //Persist to database
        customersRepository.save(customer);

        return new PurchaseResponseData(trackingNumber);

    }
}
