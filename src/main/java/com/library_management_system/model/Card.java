package com.library_management_system.model;

import com.library_management_system.enums.CardStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Table(name = "card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

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
    private Date  created_date;
    @Column(name = "updated_date",nullable = false)
    private Date updated_date;
}
