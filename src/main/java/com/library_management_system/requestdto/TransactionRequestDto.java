package com.library_management_system.requestdto;

import com.library_management_system.enums.TranscationType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TransactionRequestDto {
    private double fine;
    private String dueDate;
    private TranscationType transactionType;
    private int bookId;
    private int cardId;
}
