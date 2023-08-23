package com.kimsmile.sms_practice.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class MessageDTO {
    String to;
    String content;
    private String codeNum;

    public String randomNumber() {
        String randomNum = String.valueOf((int) (Math.random() * 899999) + 100000);

        this.codeNum = randomNum;
        return this.content = "인증번호 " + randomNum + " 를 입력해주세요.";
    }
}