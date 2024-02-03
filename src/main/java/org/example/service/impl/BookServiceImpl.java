package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository repository;

    private ModelMapper mapper;

    @Bean
    public void setup(){
        this.mapper=new ModelMapper();
    }

    @Override
    public void addBook(Book book) {
        BookEntity entity = mapper.map(book, BookEntity.class);
        repository.save(entity);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        Iterable<BookEntity> bookEntities = repository.findAll();
        for(BookEntity bookEntity : bookEntities){
            bookList.add(mapper.map(bookEntity, Book.class));
        }

        return  bookList;
    }

    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
