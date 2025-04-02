package com.library_management_system.controllers;

import com.library_management_system.model.Author;
import com.library_management_system.requestdto.AuthorRequestDto;
import com.library_management_system.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/apis")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
       String response= authorService.addAuthor(authorRequestDto);
        return response;
    }
}
