package com.mercadolibre.socialmeli_g3.unit.repository.filters;

import com.mercadolibre.socialmeli_g3.exception.BadRequestException;
import com.mercadolibre.socialmeli_g3.repository.filters.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class FilterFactoryTest {

    @Autowired
    private FilterFactory factory;

    @Test
    @DisplayName("T-00017 - getFilter_should_create_and_return_a_filter_class_successfully")
    void getFilterShouldCreateAndReturnAFilterClassSuccessfully() {
        String param ="product_name";
        Class<ProductNameFilter> expectedProductNameFilterClass = ProductNameFilter.class;
        IProductFilter obtainedProductNameFilter = factory.getFilter(param);

        assertEquals(expectedProductNameFilterClass, obtainedProductNameFilter.getClass());
    }

    @Test
    @DisplayName("T-00017 - getFilter_should_throw_a_BadRequestException_when_param_is_not_correct")
    void getFilterShouldThrowABadRequestWhenParamIsNotCorrect() {
        String param ="product_P";

        assertThrows(BadRequestException.class, () -> factory.getFilter(param));
    }
}