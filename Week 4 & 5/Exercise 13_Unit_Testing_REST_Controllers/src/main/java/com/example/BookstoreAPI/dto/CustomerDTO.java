package com.example.bookstoreapi.dto;

import org.springframework.hateoas.RepresentationModel;

public class CustomerDTO extends RepresentationModel<CustomerDTO> {

    private Long id;
    private String name;
    private String email;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
