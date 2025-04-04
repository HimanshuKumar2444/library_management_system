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
import com.library_management_system.requestdto.CardRequestDto;
import com.library_management_system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
//    2-> getTransactionById

    public Transaction getTransactionById(int id){
        Transaction transaction= transactionRepository.findById(id).get();
        if(transaction!=null){
            return transaction;
        }else {
            throw new RuntimeException("transaction with this "+ id+" not present in your database");
        }


    }


    //     3->getAll transaction Operation..
    public List<Transaction> getAll(){
        List<Transaction> transactionList=  transactionRepository.findAll();
        return transactionList;
    }

//    4-> update transaction related to particular id..

    public String  updateTransaction(int id, TransactionRequestDto transactionRequestDto){
        Transaction transaction= transactionRepository.findById(id).get();
        if(transaction!=null) {
            transaction.setDueDate(transactionRequestDto.getDueDate());
            transaction.setFine(transactionRequestDto.getFine());
            transaction.setTransactionType(transactionRequestDto.getTransactionType());
            transactionRepository.save(transaction);
            return "Update Successfully";
        }
        else{
            return "this record is not updated";
        }


    }

//    5-> delete transaction by id ...

    public String deleteByID(int id){

        Transaction transaction= transactionRepository.findById(id).get();
        if(transaction!=null){
            transactionRepository.deleteById(id);
            return "  transaction Successfully ";
        }else {
            throw new RuntimeException("not delete");
        }

    }
    //    getAlltransactionUsingPaginationAndSortingAndOrderBy..
    public List<Transaction> getAllByPage(int pageNo,int pageSize,String  sortby,String order){
        List<Transaction> transactionList=null;
        if(order.equalsIgnoreCase("ascending")){
            transactionList=transactionRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortby).ascending())).getContent();
        }else{
            transactionList=transactionRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortby).descending())).getContent();
        }

        return transactionList;
    }


}
