package com.library_management_system.controllers;
import com.library_management_system.model.Card;
import com.library_management_system.requestdto.CardRequestDto;
import com.library_management_system.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card/apis")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/save")
    public String saveBook(@RequestBody CardRequestDto cardRequestDto){
        String response= cardService.saveCard(cardRequestDto);
        return response;
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable ("id") int id){
        try {
            Card card= cardService.getCardById(id);
            return ResponseEntity.ok(card);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("card with this "+ id+" id is not present in your database");
        }

    }

    @GetMapping("/getAllCard")
    public ResponseEntity<?> getAllCard(){
        try {
            List<Card> cardList=cardService.getAll();
            return ResponseEntity.ok(cardList);
        }catch (Exception e){
            return ResponseEntity.status(204).body("No content return.. ");
        }

    }

    @GetMapping("/getByPage")
    public  List<Card> getAllByPage(@RequestParam int pageno,@RequestParam int pagesize,@RequestParam String sortby,@RequestParam String orderby){

        List<Card> cardList=  cardService.getAllByPage(pageno,pagesize,sortby,orderby);
        return  cardList;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCard(@PathVariable("id") int id,@RequestBody CardRequestDto cardRequestDto){
        try {
            return ResponseEntity.ok(cardService.updateCard(id,cardRequestDto));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("this values is not not updated ");
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable("id") int id){
        try {
            String response= cardService.deleteByID(id);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.status(404).body("card with this "+id+" id is  not found in your database");
        }


    }
}
