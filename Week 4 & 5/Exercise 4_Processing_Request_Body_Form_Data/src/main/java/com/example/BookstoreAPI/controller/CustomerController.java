package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private List<Customer> customers = new ArrayList<>();
    private Long idCounter = 1L;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setId(idCounter++);
        customers.add(customer);
        return customer;
    }

    @PostMapping("/register")
    public Customer registerCustomer(@RequestParam String name,
                                     @RequestParam String email,
                                     @RequestParam String password) {
        Customer customer = new Customer(idCounter++, name, email, password);
        customers.add(customer);
        return customer;
    }
}
