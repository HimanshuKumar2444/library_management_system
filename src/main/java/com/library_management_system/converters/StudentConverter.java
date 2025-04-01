package com.library_management_system.converters;

import com.library_management_system.model.Student;
import com.library_management_system.requestdto.StudentRequestDto;

public class StudentConverter {
//    converter-> it is convert requestdto class into model class..

//    private String name;
//    private int mobile;
//    private String email;
//    private int dept;
//    private String sem;
//    private int address;
//    private String dob;
//    private String gender;
//    private  String section;

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
        return student;

    }
}
