package com.library_management_system.controllers;

import com.library_management_system.model.Author;
import com.library_management_system.requestdto.AuthorRequestDto;
import com.library_management_system.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable ("id") int id){
        try {
            Author author= authorService.getAuthorById(id);
            return ResponseEntity.ok(author);
        }catch (Exception e){
           return ResponseEntity.internalServerError().body("Author with this "+ id+" id is not present in your database");
        }

    }

    @GetMapping("/getAllAuthor")
    public ResponseEntity<?> getAllAuthor(){
        try {
            List<Author> authorList=authorService.getAll();
            return ResponseEntity.ok(authorList);
        }catch (Exception e){
            return ResponseEntity.status(204).body("No contend return ");
        }

    }

    @GetMapping("/getByPage")
    public  List<Author> getAllByPage(@RequestParam int pageno,@RequestParam int pagesize,@RequestParam String sortby,@RequestParam String orderby){

        List<Author> authorList=  authorService.getAllByPage(pageno,pagesize,sortby,orderby);
        return  authorList;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable("id") int id,@RequestBody AuthorRequestDto authorRequestDto){
        try {
            return ResponseEntity.ok(authorService.updateAuthor(id,authorRequestDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("this values is not not updated ");
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteauthor(@PathVariable("id") int id){
        try {
            String response= authorService.deleteByID(id);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.status(404).body("author with this "+id+" id is  not found in your database");
        }


    }
}
