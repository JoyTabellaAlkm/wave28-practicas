package com.example.qa_tester.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MessageDto {
    String message;

    public MessageDto(String message) {
        this.message = message;
    }
}
