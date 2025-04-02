package com.library_management_system.controllers;

import com.library_management_system.requestdto.BookRequestDto;
import com.library_management_system.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/apis")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public String saveBook(@RequestBody BookRequestDto bookRequestDto){
       String response= bookService.addBook(bookRequestDto);
        return response;
    }

}
