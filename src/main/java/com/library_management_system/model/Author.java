package com.library_management_system.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Author {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="gender", nullable = false)
    private String gender;

    @Column(name="country", nullable = false)
    private String country;

    @Column(name="rating", nullable = false)
    private double rating;

         // one author writes many books so book list is created to store multiple books
//    private List<Book> bookList;
}
