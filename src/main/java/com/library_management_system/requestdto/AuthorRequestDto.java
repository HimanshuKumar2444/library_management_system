package com.library_management_system.requestdto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthorRequestDto {
    private String name;
    private String email;
    private String gender;
    private String country;
    private double rating;
}
