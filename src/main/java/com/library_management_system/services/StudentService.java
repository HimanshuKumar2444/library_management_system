package com.library_management_system.services;

import com.library_management_system.converters.StudentConverter;
import com.library_management_system.enums.CardStatus;
import com.library_management_system.model.Card;
import com.library_management_system.model.Student;
import com.library_management_system.repository.StudentRepository;
import com.library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
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
       return null;
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
        studentRepository.deleteById(id);
        return " Student Delete Successfully ";
    }
}
