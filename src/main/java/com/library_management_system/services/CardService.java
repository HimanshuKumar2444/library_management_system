package com.library_management_system.services;

import com.library_management_system.converters.CardConverter;
import com.library_management_system.model.Book;
import com.library_management_system.model.Card;
import com.library_management_system.model.Student;
import com.library_management_system.repository.CardRepository;
import com.library_management_system.repository.StudentRepository;
import com.library_management_system.requestdto.BookRequestDto;
import com.library_management_system.requestdto.CardRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private StudentRepository studentRepository;

    public String saveCard(CardRequestDto cardRequestDto){
       Card card= CardConverter.convertCardRequestDtoIntoCard(cardRequestDto);
       Student student =studentRepository.findById(cardRequestDto.getStudentId()).get();
       card.setStudent(student);
       cardRepository.save(card);
       return "Card save SuccessFully";

    }
//      2-> getCardById

    public Card getCardById(int id){
        Card card= cardRepository.findById(id).get();
        if(card!=null){
            return card;
        }else {
            throw new RuntimeException("card with this "+ id+" not present in your database");
        }


    }


    //     3->getAll Card Operation..
    public List<Card> getAll(){
        List<Card> cardList=  cardRepository.findAll();
        return cardList;
    }

//    4-> update Card related to particular id..

    public String  updateCard(int id, CardRequestDto cardRequestDto){
        Card card=cardRepository.findById(id).get();
        if(card!=null) {
            card.setCard_status(cardRequestDto.getCard_status());
            card.setBlood_group(cardRequestDto.getBlood_group());
            cardRepository.save(card);
            return "Update Successfully";
        }
        else{
            return "this record is not updated";
        }


    }

//    5-> delete Card by id ...

    public String deleteByID(int id){

        Card card= cardRepository.findById(id).get();
        if(card!=null){
            cardRepository.deleteById(id);
            return " card Delete Successfully ";
        }else {
            throw new RuntimeException("not delete");
        }

    }
    //    getAllCardUsingPaginationAndSortingAndOrderBy..
    public List<Card> getAllByPage(int pageNo,int pageSize,String  sortby,String order){
        List<Card> cardList=null;
        if(order.equalsIgnoreCase("ascending")){
            cardList=cardRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortby).ascending())).getContent();
        }else{
            cardList=cardRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(sortby).descending())).getContent();
        }

        return cardList;
    }

}
