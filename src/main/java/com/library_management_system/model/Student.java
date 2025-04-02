package com.library_management_system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table

public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "student_id")

    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String mobile;
    @Column(nullable = false,unique = true)
    private String email;
    private String dept;
    @Column(nullable = false)
    private String sem;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String dob;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private  String section;
    @JsonManagedReference
    @OneToOne(mappedBy = "student" ,cascade = CascadeType.ALL)
    private Card card;
    private String bloodGroup;

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
