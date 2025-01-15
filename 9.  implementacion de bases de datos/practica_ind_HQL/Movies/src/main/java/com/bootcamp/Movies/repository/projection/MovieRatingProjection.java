package com.bootcamp.Movies.repository.projection;

import java.math.BigDecimal;

public interface MovieRatingProjection {
    String getTitle();
    BigDecimal getRating();
}
