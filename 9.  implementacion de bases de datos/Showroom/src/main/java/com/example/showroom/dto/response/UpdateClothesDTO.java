package com.example.showroom.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClothesDTO {
    ClothesDTOResponse clothesDTOResponse;
    MessageDTO messageDTO;
}
