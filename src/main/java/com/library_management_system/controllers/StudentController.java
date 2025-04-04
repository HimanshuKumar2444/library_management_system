package com.library_management_system.controllers;

import com.library_management_system.model.Student;
import com.library_management_system.requestdto.StudentRequestDto;
import com.library_management_system.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {
@Autowired
private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequestDto studentRequestDto){
       try {
           String response= studentService.saveStudent(studentRequestDto);
           return ResponseEntity.ok(response);
       }catch (Exception e){
           return ResponseEntity.internalServerError().body("some exception occur in during saving operation");

       }


    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getByID(@PathVariable("id") int id){

        Student student=  studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(){
       return studentService.getAll();
    }

   @GetMapping("/getByPage")
    public  List<Student> getAllByPage(@RequestParam int pageno,@RequestParam int pagesize,@RequestParam String sortby,@RequestParam String orderby){

      List<Student> studentList=  studentService.getAllByPage(pageno,pagesize,sortby,orderby);
      return  studentList;
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") int id,@RequestBody StudentRequestDto studentRequestDto){
      return   studentService.updateStudent(id,studentRequestDto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id){
        try {
            String response= studentService.deleteByID(id);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.status(404).body("student with this "+id+" id is  not found in your database");
        }


    }
// customise query for dept...
    @GetMapping("/getByDept")
    public List<Student> getByID(@RequestParam String dept){

        return  studentService.findByDept(dept);
    }
}
