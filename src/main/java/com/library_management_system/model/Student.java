package com.library_management_system.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "student_id")

    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int mobile;
    @Column(nullable = false,unique = true)
    private String email;
    private int dept;
    @Column(nullable = false)
    private String sem;
    @Column(nullable = false)
    private int address;
    @Column(nullable = false)
    private String dob;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private  String section;


}
