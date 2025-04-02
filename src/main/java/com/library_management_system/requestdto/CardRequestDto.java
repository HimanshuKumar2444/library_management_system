package com.library_management_system.requestdto;

import com.library_management_system.enums.CardStatus;


import java.util.Date;

public class CardRequestDto {
    private CardStatus card_status;
    private String blood_group;
    private int studentId;

    public CardStatus getCard_status() {
        return card_status;
    }

    public void setCard_status(CardStatus card_status) {
        this.card_status = card_status;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
