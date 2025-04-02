package com.library_management_system.controllers;

import com.library_management_system.requestdto.StudentRequestDto;
import com.library_management_system.requestdto.TransactionRequestDto;
import com.library_management_system.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
