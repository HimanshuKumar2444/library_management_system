package com.library_management_system.services;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.library_management_system.converters.TransactionConverter;
import com.library_management_system.model.Book;
import com.library_management_system.model.Card;
import com.library_management_system.model.Transaction;
import com.library_management_system.repository.BookRepository;
import com.library_management_system.repository.CardRepository;
import com.library_management_system.repository.TransactionRepository;
import com.library_management_system.requestdto.BookRequestDto;
import com.library_management_system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CardRepository cardRepository;

    public String addTransaction(TransactionRequestDto transactionRequestDto){

      Transaction transaction=  TransactionConverter.convertTransactionRequestDtoIntoTransaction(transactionRequestDto);


//      we have two foiegn key book_id and card_id..firstlt set their value then save

//        here we can set book details
          Book book= bookRepository.findById(transactionRequestDto.getBookId()).get();
          transaction.setBook(book);
//        here we can set card details
        Card card=cardRepository.findById(transactionRequestDto.getCardId()).get();
        transaction.setCard(card);

        transactionRepository.save(transaction);
        return "transaction saved successfully";
    }
}
