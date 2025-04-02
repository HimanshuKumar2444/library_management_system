package com.library_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.library_management_system.enums.TranscationType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="transactions")


public class Transaction {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="transaction_date", nullable = false)
    @CreationTimestamp
    private Date transactionDate;

    @Column(name="fine")
    private double fine;

    @Column(name="due_date", nullable = false)
    private String dueDate;

    @Column(name="transaction_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TranscationType transactionType;

@ManyToOne
@JoinColumn
@JsonBackReference
    private Card card;
@JsonBackReference
@JoinColumn
@ManyToOne
    private Book book;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TranscationType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TranscationType transactionType) {
        this.transactionType = transactionType;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
