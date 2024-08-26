package com.example.bookstoreapi.mapper;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public BookDTO toDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public Book toEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }
}
