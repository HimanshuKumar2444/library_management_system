package com.library_management_system.model;

import com.library_management_system.enums.TranscationType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Transaction {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="transaction_date", nullable = false)
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
    private Card card;
@JoinColumn
@ManyToOne
    private Book book;
}
