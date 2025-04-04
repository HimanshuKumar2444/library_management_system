package com.library_management_system.controllers;

import com.library_management_system.model.Card;
import com.library_management_system.model.Transaction;
import com.library_management_system.requestdto.CardRequestDto;
import com.library_management_system.requestdto.StudentRequestDto;
import com.library_management_system.requestdto.TransactionRequestDto;
import com.library_management_system.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction/apis")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto){

        String response=transactionService.addTransaction(transactionRequestDto);
        return response;

    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable ("id") int id){
        try {
            Transaction transaction= transactionService.getTransactionById(id);
            return ResponseEntity.ok(transaction);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("transaction with this "+ id+" id is not present in your database");
        }

    }

    @GetMapping("/getAllCard")
    public ResponseEntity<?> getAllTransaction(){
        try {
            List<Transaction> transaction=transactionService.getAll();
            return ResponseEntity.ok(transaction);
        }catch (Exception e){
            return ResponseEntity.status(204).body("No content return.. ");
        }

    }

    @GetMapping("/getByPage")
    public  List<Transaction> getAllByPage(@RequestParam int pageno,@RequestParam int pagesize,@RequestParam String sortby,@RequestParam String orderby){

        List<Transaction> transactionList=  transactionService.getAllByPage(pageno,pagesize,sortby,orderby);
        return  transactionList;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable("id") int id,@RequestBody TransactionRequestDto transactionRequestDto){
        try {
            return ResponseEntity.ok(transactionService.updateTransaction(id,transactionRequestDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("this values is not not updated ");
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable("id") int id){
        try {
            String response= transactionService.deleteByID(id);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.status(404).body("Transaction with this "+id+" id is  not found in your database");
        }


    }
}
