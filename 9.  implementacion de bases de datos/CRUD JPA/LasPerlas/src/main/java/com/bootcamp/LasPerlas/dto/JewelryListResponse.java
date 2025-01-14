package com.bootcamp.LasPerlas.dto;

import com.bootcamp.LasPerlas.model.Joya;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelryListResponse {
    private int status;
    private List<Joya> jewerlyList;
}
