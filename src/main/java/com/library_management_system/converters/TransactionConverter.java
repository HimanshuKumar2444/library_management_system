package com.library_management_system.converters;

import com.library_management_system.model.Transaction;
import com.library_management_system.requestdto.TransactionRequestDto;

public class TransactionConverter {
    public static Transaction convertTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction = new Transaction();

        transaction.setDueDate(transactionRequestDto.getDueDate());
        transaction.setFine(transactionRequestDto.getFine());
        transaction.setTransactionType(transactionRequestDto.getTransactionType());

        return transaction;
    }
}
