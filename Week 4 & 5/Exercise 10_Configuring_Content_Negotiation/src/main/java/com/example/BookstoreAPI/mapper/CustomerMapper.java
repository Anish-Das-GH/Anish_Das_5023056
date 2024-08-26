package com.example.bookstoreapi.mapper;

import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public CustomerDTO toDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public Customer toEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }
}
