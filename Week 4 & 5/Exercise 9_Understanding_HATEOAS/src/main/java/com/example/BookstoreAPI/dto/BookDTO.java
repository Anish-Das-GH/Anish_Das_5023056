package com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "book")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private double price;
    private String isbn;

 
}
