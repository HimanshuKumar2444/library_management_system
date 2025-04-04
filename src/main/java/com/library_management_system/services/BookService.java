package com.library_management_system.services;

import com.library_management_system.controllers.BookController;
import com.library_management_system.converters.BookConverter;
import com.library_management_system.model.Author;
import com.library_management_system.model.Book;
import com.library_management_system.model.Card;
import com.library_management_system.repository.AuthorRepository;
import com.library_management_system.repository.BookRepository;
import com.library_management_system.repository.CardRepository;
import com.library_management_system.requestdto.AuthorRequestDto;
import com.library_management_system.requestdto.BookRequestDto;
import com.library_management_system.requestdto.CardRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

//     2-> getBookById

    public Book getBookById(int id){
        Book book= bookRepository.findById(id).get();
        if(book!=null){
            return book;
        }else {
            throw new RuntimeException("book with this "+ id+" not present in your database");
        }


    }


    //     3->getAll Book Operation..
    public List<Book> getAll(){
        List<Book> bookList=  bookRepository.findAll();
        return bookList;
    }

//    4-> update Book related to particular id..

    public String  updateBook(int id, BookRequestDto bookRequestDto){
        Book book=bookRepository.findById(id).get();
        if(book!=null) {
            book.setTitle(bookRequestDto.getTitle());
            book.setPages(bookRequestDto.getPages());
            book.setPublisher_name(bookRequestDto.getPublisher_name());
            book.setPublish_date(bookRequestDto.getPublish_date());
            book.setEdition(bookRequestDto.getEdition());
            book.setCategory(bookRequestDto.getCategory());
            book.setPrice(bookRequestDto.getPrice());
            book.setRackNo(bookRequestDto.getRackNo());
            book.setAvailability(bookRequestDto.isAvailability());
            bookRepository.save(book);
            return "Update Successfully";
        }
        else{
            return "this record is not updated";
        }


    }

//    5-> delete Book by id ...

    public String deleteByID(int id){

        Book book= bookRepository.findById(id).get();
        if(book!=null){
            bookRepository.deleteById(id);
            return " Book Delete Successfully ";
        }else {
            throw new RuntimeException("not delete");
        }

    }
//    getAllBookUsingPaginationAndSortingAndOrderBy..
    public List<Book> getAllByPage(int pageNo,int pageSize,String  sortby,String order){
        List<Book> bookList=null;
        if(order.equalsIgnoreCase("ascending")){
            bookList=bookRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortby).ascending())).getContent();
        }else{
            bookList=bookRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortby).descending())).getContent();
        }

        return bookList;
    }



}
