package com.library_management_system.converters;

import com.library_management_system.enums.Category;
import com.library_management_system.model.Book;
import com.library_management_system.requestdto.BookRequestDto;

public class BookConverter {
    //this particular field will be converts into model class..
//    private String title;
//    private int pages;
//    private String publisher_name;
//    private String publish_date;
//    private String edition;
//    private Category category;
//    private double price;
//    private String rackNo;
//    private boolean availability;


    public static Book convertBookRequestDtoIntoBook(BookRequestDto bookRequestDto){
        Book book=new Book();

        book.setTitle(bookRequestDto.getTitle());
        book.setPages(bookRequestDto.getPages());
        book.setPublisher_name(bookRequestDto.getPublisher_name());
        book.setPublish_date(bookRequestDto.getPublish_date());
        book.setEdition(bookRequestDto.getEdition());
        book.setCategory(bookRequestDto.getCategory());
        book.setPrice(bookRequestDto.getPrice());
        book.setRackNo(bookRequestDto.getRackNo());
        book.setAvailability(bookRequestDto.isAvailability());

        return book;
    }
}
