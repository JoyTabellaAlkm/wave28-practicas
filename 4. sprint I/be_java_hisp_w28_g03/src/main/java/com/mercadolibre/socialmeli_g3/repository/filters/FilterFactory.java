package com.mercadolibre.socialmeli_g3.repository.filters;

import com.mercadolibre.socialmeli_g3.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FilterFactory {
    private final Map<String, IProductFilter> filters;

    public FilterFactory() {
        filters = Map.of(
                "product_name", new ProductNameFilter(),
                "brand", new BrandFilter(),
                "type", new TypeFilter(),
                "color", new ColorFilter()
        );
    }

    public IProductFilter getFilter(String filterCriteria) {
        validateFilterName(filterCriteria);
        return filters.get(filterCriteria);
    }

    private void validateFilterName(String name) {
        if(filters.get(name) == null) {
            throw new BadRequestException("The provided filter name '" + name + "' is not valid");
        }
    }
}
