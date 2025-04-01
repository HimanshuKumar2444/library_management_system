package com.library_management_system.requestdto;

import com.library_management_system.enums.CardStatus;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
@Getter
@Setter

public class CardRequestDto {
    private CardStatus card_status;
    private String blood_group;
    private int studentId;
}
