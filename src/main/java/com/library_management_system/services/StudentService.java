package com.library_management_system.services;

import com.library_management_system.converters.StudentConverter;
import com.library_management_system.enums.CardStatus;
import com.library_management_system.model.Card;
import com.library_management_system.model.Student;
import com.library_management_system.repository.StudentRepository;
import com.library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
    @Autowired
   private StudentRepository studentRepository;

//    1-> save operation..

    public String saveStudent(StudentRequestDto studentRequestDto){
        Student student=StudentConverter.convertRequestDtoIntoStudent(studentRequestDto);
//        whenever student is added then automatically card also added..
        Card card=new Card();
        card.setCard_status(CardStatus.ACTIVE);
        card.setBlood_group(studentRequestDto.getBloodGroup());
        card.setStudent(student);
        student.setCard(card);
        studentRepository.save(student);
        return "student and card save successfully...";
    }

//    2->getBy ID operation

    public Student  getStudentById(int id){
     Optional<Student> student= studentRepository.findById(id);
     if(student.isPresent()){
         return student.get();
     }
       throw new RuntimeException("student with this "+id+" not found");
    }

//    3->getAll Student Operation..
    public List<Student> getAll(){
      List<Student> students=  studentRepository.findAll();
      return students;
    }

//    4-> update student relatedto particular id..

    public String  updateStudent(int id,StudentRequestDto studentRequestDto){
        Student student=studentRepository.findById(id).get();
        if(student!=null) {
            student.setName(studentRequestDto.getName());
            student.setMobile(studentRequestDto.getMobile());
            student.setEmail(studentRequestDto.getEmail());
            student.setDept(studentRequestDto.getDept());
            student.setSem(studentRequestDto.getSem());
            student.setAddress(studentRequestDto.getAddress());
            student.setDob(studentRequestDto.getDob());
            student.setGender(studentRequestDto.getGender());
            student.setSection(studentRequestDto.getSection());
            student.setBloodGroup(student.getBloodGroup());
            studentRepository.save(student);
            return "Update Successfully";
        }
        else{
            return "this record is not updated";
        }


    }
//    5-> delete student by id ...

    public String deleteByID(int id){

        Student student=studentRepository.findById(id).get();
        if(student!=null){
            studentRepository.deleteById(id);
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

            public List<Student> getAllByPage(int pageNo,int pageSize,String  sortby,String order){
                List<Student> studentList=null;
                if(order.equalsIgnoreCase("ascending")){
                     studentList=studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortby).ascending())).getContent();
                }else{
                    studentList=studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortby).descending())).getContent();
                }

            return studentList;
            }

//      exapmle of customise query

    public List<Student> findByDept(String dept){
        List<Student> studentList=  studentRepository.findByDept(dept);

        return studentList;
    }

//    if you want use pagination then add-> studentRepository.findByDept(dept,PageRequest.of(pageNo,pageSize);

//    public List<Student> findByDept(String dept){
//              List<Student> studentList=  studentRepository.findByDept(dept,PageRequest.of(1,3));
//
//              return studentList;
//    }

}
