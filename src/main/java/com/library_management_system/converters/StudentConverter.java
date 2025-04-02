package com.library_management_system.converters;

import com.library_management_system.model.Student;
import com.library_management_system.requestdto.StudentRequestDto;

public class StudentConverter {
//    converter-> it is convert requestdto class into model class..



    public static Student convertRequestDtoIntoStudent(StudentRequestDto studentRequestDto){
        Student student=new Student();
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
        return student;

    }
}
