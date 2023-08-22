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
}