package com.library_management_system.services;


import com.library_management_system.converters.AuthorConverter;
import com.library_management_system.model.Author;
import com.library_management_system.repository.AuthorRepository;
import com.library_management_system.requestdto.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired

    private AuthorRepository authorRepository;


    public String addAuthor(AuthorRequestDto authorRequestDto){
       Author author= AuthorConverter.convertAuthorRequestDtoIntoAuthor(authorRequestDto);
       authorRepository.save(author);
       return "author save successfully";
    }
}
