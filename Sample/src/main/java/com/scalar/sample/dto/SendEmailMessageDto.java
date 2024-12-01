package com.scalar.sample.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SendEmailMessageDto {
    private String from;
    private String to;
    private String subject;
    private String body;
}
