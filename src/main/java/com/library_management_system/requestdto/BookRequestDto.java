package com.library_management_system.requestdto;

import com.library_management_system.enums.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookRequestDto {
    private String title;
    private int age;
    private String publisher_name;
    private String publish_date;
    private String edition;
    private Category category;
    private double price;
    private String rackNo;
    private boolean availability;
    private int authorId;
    private int cardId;
}
