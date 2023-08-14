package com.example.task1.bootstrap;

import com.example.task1.dao.CustomersRepository;
import com.example.task1.dao.DivisionsRepository;
import com.example.task1.entities.Customer;
import com.example.task1.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomersRepository customersRepository;
    private final DivisionsRepository divisionsRepository;

    public BootStrapData(CustomersRepository customersRepository, DivisionsRepository divisionsRepository) {
        this.customersRepository = customersRepository;
        this.divisionsRepository = divisionsRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customersRepository.count() <= 1) {
            Long num = 43L;
            Division division = divisionsRepository.getReferenceById(num);

            Customer customer1 = new Customer("Mark", "Markson", "468 W Niagra Drive", "84625", division, "801-555-5643");
            Customer customer2 = new Customer("Dave", "Smith", "8943 E Piccolo Way", "88456", division, "801-555-6548");
            Customer customer3 = new Customer("Rick", "Rinaldo", "1354 S Richards St.", "83158", division, "801-555-1354");
            Customer customer4 = new Customer("Sally", "Sampson", "645 N Churchill Drive", "81654", division, "801-555-8462");
            Customer customer5 = new Customer("Greg", "Watts", "8462 W Aspen Drive", "88642", division, "801-555-3156");

            customersRepository.save(customer1);
            customersRepository.save(customer2);
            customersRepository.save(customer3);
            customersRepository.save(customer4);
            customersRepository.save(customer5);

        }
    }

}
