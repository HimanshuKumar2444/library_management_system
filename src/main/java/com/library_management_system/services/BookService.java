package com.library_management_system.services;

import com.library_management_system.controllers.BookController;
import com.library_management_system.converters.BookConverter;
import com.library_management_system.model.Author;
import com.library_management_system.model.Book;
import com.library_management_system.model.Card;
import com.library_management_system.repository.AuthorRepository;
import com.library_management_system.repository.BookRepository;
import com.library_management_system.repository.CardRepository;
import com.library_management_system.requestdto.BookRequestDto;
import com.library_management_system.requestdto.CardRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CardRepository cardRepository;

    public String addBook(BookRequestDto bookRequestDto){


       Book book= BookConverter.convertBookRequestDtoIntoBook(bookRequestDto);

//       here we have foreign key as auther id and card id..
//        using author id we  can all details about author..
       Author author= authorRepository.findById(bookRequestDto.getAuthorId()).get();
      book.setAuthor(author);
//        using author id we  can all details about author..

       Card card= cardRepository.findById(bookRequestDto.getCardId()).get();
       book.setCard(card);

       bookRepository.save(book);

       return "book saved successfully";

    }

}
