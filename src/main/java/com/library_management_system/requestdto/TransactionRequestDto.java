package com.library_management_system.requestdto;

import com.library_management_system.enums.TranscationType;


public class TransactionRequestDto {
    private double fine;
    private String dueDate;
    private TranscationType transactionType;
    private int bookId;
    private int cardId;

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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
