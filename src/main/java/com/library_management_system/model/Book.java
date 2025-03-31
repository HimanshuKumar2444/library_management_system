package com.library_management_system.model;

import com.library_management_system.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String publisher_name;
    @Column(nullable = false)
    private String publish_date;
    @Column(nullable = false)
    private String edition;
    @Column(nullable = false)
    private Category category;
    @Column(nullable = false)

    private double price;
    @Column(nullable = false)

    private String rackNo;
    @Column(nullable = false)


    private boolean availability;

//    private Author author;
//    private Card card;
//
//    private List<Transaction> transactionList;


}
