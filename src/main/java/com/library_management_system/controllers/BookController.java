package com.library_management_system.controllers;

import com.library_management_system.model.Author;
import com.library_management_system.model.Book;
import com.library_management_system.requestdto.AuthorRequestDto;
import com.library_management_system.requestdto.BookRequestDto;
import com.library_management_system.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable ("id") int id){
        try {
            Book book= bookService.getBookById(id);
            return ResponseEntity.ok(book);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("book with this "+ id+" id is not present in your database");
        }

    }

    @GetMapping("/getAllBook")
    public ResponseEntity<?> getAllBook(){
        try {
            List<Book> bookList=bookService.getAll();
            return ResponseEntity.ok(bookList);
        }catch (Exception e){
            return ResponseEntity.status(204).body("No content return.. ");
        }

    }

    @GetMapping("/getByPage")
    public  List<Book> getAllByPage(@RequestParam int pageno,@RequestParam int pagesize,@RequestParam String sortby,@RequestParam String orderby){

        List<Book> bookList=  bookService.getAllByPage(pageno,pagesize,sortby,orderby);
        return  bookList;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") int id,@RequestBody BookRequestDto bookRequestDto){
        try {
            return ResponseEntity.ok(bookService.updateBook(id,bookRequestDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("this values is not not updated ");
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") int id){
        try {
            String response= bookService.deleteByID(id);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.status(404).body("book with this "+id+" id is  not found in your database");
        }


    }

}
