package com.library_management_system.requestdto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentRequestDto {
    private String name;
    private int mobile;
    private String email;
    private int dept;
    private String sem;
    private int address;
    private String dob;
    private String gender;
    private  String section;
}
