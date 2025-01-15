package com.bootcamp.Movies.repository.projection;

import java.math.BigDecimal;

public interface ActorsProjection {
    public String getFirstName();
    public String getLastName();
    public BigDecimal getRating();
}
