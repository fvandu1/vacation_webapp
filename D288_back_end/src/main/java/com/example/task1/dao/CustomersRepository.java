package com.example.task1.dao;

import com.example.task1.entities.Customer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CustomersRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select * from customers where customer_id = ?1", nativeQuery = true)
    public Customer findByIdCustom(Long id);
}
