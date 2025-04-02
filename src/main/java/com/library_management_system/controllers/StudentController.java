package com.library_management_system.controllers;

import com.library_management_system.model.Student;
import com.library_management_system.requestdto.StudentRequestDto;
import com.library_management_system.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {
@Autowired
private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){

       String response= studentService.saveStudent(studentRequestDto);
       return response;

    }


    @GetMapping("/get/{id}")
    public Student getByID(@PathVariable("id") int id){
     return  studentService.getStudentById(id);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(){
       return studentService.getAll();
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") int id,@RequestBody StudentRequestDto studentRequestDto){
      return   studentService.updateStudent(id,studentRequestDto);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id){
       return studentService.deleteByID(id);
    }
}
