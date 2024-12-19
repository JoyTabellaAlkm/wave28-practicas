package com.meli.be_java_hisp_w28_g01.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Buyer extends User{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buyer)) return false;
        Buyer buyer = (Buyer) o;
        return id == buyer.id && name.equals(buyer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
