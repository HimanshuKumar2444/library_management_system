package com.library_management_system.services;


import com.library_management_system.converters.AuthorConverter;
import com.library_management_system.model.Author;
import com.library_management_system.model.Student;
import com.library_management_system.repository.AuthorRepository;
import com.library_management_system.requestdto.AuthorRequestDto;
import com.library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired

    private AuthorRepository authorRepository;

//1-> save author..
    public String addAuthor(AuthorRequestDto authorRequestDto){
       Author author= AuthorConverter.convertAuthorRequestDtoIntoAuthor(authorRequestDto);
       authorRepository.save(author);
       return "author save successfully";
    }
//    2-> getAuthorById

    public Author getAuthorById(int id){
       Author author= authorRepository.findById(id).get();
       if(author!=null){
           return author;
       }else {
           throw new RuntimeException("Author with this "+ id+" not present in your database");
       }


    }


//     3->getAll Student Operation..
    public List<Author> getAll(){
        List<Author> authorList=  authorRepository.findAll();
        return authorList;
    }

//    4-> update student relatedto particular id..

    public String  updateAuthor(int id, AuthorRequestDto authorRequestDto){
        Author author=authorRepository.findById(id).get();
        if(author!=null) {
            author.setName(authorRequestDto.getName());
            author.setEmail(authorRequestDto.getEmail());
            author.setGender(authorRequestDto.getGender());
            author.setCountry(authorRequestDto.getCountry());
            author.setRating(authorRequestDto.getRating());
            authorRepository.save(author);
            return "Update Successfully";
        }
        else{
            return "this record is not updated";
        }


    }

//    5-> delete student by id ...

    public String deleteByID(int id){

        Author author=authorRepository.findById(id).get();
        if(author!=null){
            authorRepository.deleteById(id);
            return " Student Delete Successfully ";
        }else {
            throw new RuntimeException("not delete");
        }

    }


    /*
    Pagination - fetching or getting the records or data in the form of pages
    pagenumber - the number of page we want to see(0,1,2,3,4,5,....)
    pagesize - total number of records in each page(fixed for all pages)

    total number of records - 28, page size - 5
    0th page - 1-5
    1st page - 6-10
    2nd page - 11-15
    3rd page - 16-20
    4th page - 21-25
    5th page - 26-28
    6th page - 0

    total number of records - 11, page size - 3
    0th page - 1-3
    1st page - 4-6
    2nd page - 7-9
    3rd page - 10-11

    sorting - arranging the record based on ascending or descending order

    only pagination
    public List<Student> getStudentByPage(int pageNo, int pageSize){
        List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo,pageSize)).getContent();
        return studentList;
    }
     */
//    **-> pagination with sorting by particular model variable  in ascending and descending order..

    public List<Author> getAllByPage(int pageNo,int pageSize,String  sortby,String order){
        List<Author> authorList=null;
        if(order.equalsIgnoreCase("ascending")){
            authorList=authorRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortby).ascending())).getContent();
        }else{
            authorList=authorRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortby).descending())).getContent();
        }

        return authorList;
    }

//      exapmle of customise query


//    public List<Student> findByDept(String dept){
//        List<Student> studentList=  studentRepository.findByDept(dept);
//
//        return studentList;
//    }

//    if you want use pagination then add-> studentRepository.findByDept(dept,PageRequest.of(pageNo,pageSize);

//    public List<Student> findByDept(String dept){
//              List<Student> studentList=  studentRepository.findByDept(dept,PageRequest.of(1,3));
//
//              return studentList;
//    }

}
