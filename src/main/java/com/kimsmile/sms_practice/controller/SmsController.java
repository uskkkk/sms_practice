package com.kimsmile.sms_practice.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.kimsmile.sms_practice.DTO.MessageDTO;
import com.kimsmile.sms_practice.DTO.SmsResponseDTO;
import com.kimsmile.sms_practice.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClientException;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;

    private static String codeNum;

    @GetMapping("/send")
    public String getSmsPage() {
        return "sendSms";
    }

    @PostMapping("/sms/send")
    public String sendSms(MessageDTO messageDto, Model model) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {

        SmsResponseDTO response = smsService.sendSms(messageDto);

        this.codeNum = messageDto.getCodeNum();

        model.addAttribute("response", response);
        return "auth";
    }

    @PostMapping("/sms/auth")
    public String authSms(String codeNum) throws Exception {

        if(!this.codeNum.equals(codeNum)) {
            throw new Exception("번호가 일치하지 않습니다.");
        }

        return "result";
    }
}
