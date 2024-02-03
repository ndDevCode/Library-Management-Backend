package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<Object,Object>> deleteBook(@PathVariable Long id){
        service.deleteBook(id);
        HashMap<Object, Object> response = new HashMap<>();
        response.put("response","Delete Success!");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
