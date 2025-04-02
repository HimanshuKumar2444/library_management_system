package com.library_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.library_management_system.enums.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")


public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id",nullable = false)
    private int id;
@Column(nullable = false)
@Enumerated(value =EnumType.STRING)
    private CardStatus card_status;
    private String blood_group;

    @Column(name = "created_date",nullable = false)
    @CreationTimestamp
    private Date  created_date=new Date();
    @Column(name = "updated_date",nullable = false)

    @UpdateTimestamp
    private Date updated_date;
    @JsonBackReference
    @JoinColumn // it joins the primary key student id of student table as a foreign key in card table
    @OneToOne // one card is assigned to one student (we have one to one relation between card and student)
    private Student student;
    @OneToMany(mappedBy = "card")
    @JsonManagedReference
    private List<Book> bookList;

    @JsonManagedReference
    @OneToMany(mappedBy = "card")
    private List<Transaction> transactionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardStatus getCard_status() {
        return card_status;
    }

    public void setCard_status(CardStatus card_status) {
        this.card_status = card_status;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
