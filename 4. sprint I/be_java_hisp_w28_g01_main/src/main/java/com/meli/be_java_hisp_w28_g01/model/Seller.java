package com.meli.be_java_hisp_w28_g01.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Seller extends User{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seller)) return false;
        Seller seller = (Seller) o;
        return id == seller.id && name.equals(seller.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
