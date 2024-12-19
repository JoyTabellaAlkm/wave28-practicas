package com.meli.be_java_hisp_w28_g01.dto;

import com.meli.be_java_hisp_w28_g01.model.Buyer;
import com.meli.be_java_hisp_w28_g01.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowDto {
    Buyer buyer;
    Seller seller;
}
