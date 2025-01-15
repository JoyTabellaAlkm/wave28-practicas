package com.mercadolibre.showroom.model;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleClothingId implements Serializable {

    private Long saleNumber;
    private Long clothingCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleClothingId that = (SaleClothingId) o;
        return Objects.equals(saleNumber, that.saleNumber) &&
                Objects.equals(clothingCode, that.clothingCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleNumber, clothingCode);
    }
}