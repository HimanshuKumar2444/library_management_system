package com.library_management_system.converters;

import com.library_management_system.model.Author;
import com.library_management_system.requestdto.AuthorRequestDto;

public class AuthorConverter {
//this particular field will be converts into model class..
//    private String name;
//    private String email;
//    private String gender;
//    private String country;
//    private double rating;

    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto){
        Author author=new Author();
        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setGender(authorRequestDto.getGender());
        author.setCountry(authorRequestDto.getCountry());
        author.setRating(authorRequestDto.getRating());
        return author;

    }
}
