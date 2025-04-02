package com.library_management_system.converters;

import com.library_management_system.model.Card;
import com.library_management_system.requestdto.CardRequestDto;

public class CardConverter {

    public static Card convertCardRequestDtoIntoCard(CardRequestDto cardRequestDto){
        Card card = new Card();

        card.setCard_status(cardRequestDto.getCard_status());
        card.setBlood_group(cardRequestDto.getBlood_group());

        // foreign keys present in request dto are not used in converters.
        // they are directly used in service class while writing business logics

        return card;

    }
}
