package com.daofab.transactions.validator;

import com.daofab.transactions.validator.validationAnnotation.SortByIdOnly;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class ParentSortByValidator implements ConstraintValidator<SortByIdOnly, Pageable> {

    static final String PROPERTY_NOT_FOUND_MESSAGE = "The following sort fields [%s] are not within the allowed fields. "
            + "Allowed sort fields are: [%s]";

    @Override
    public boolean isValid(Pageable pageable, ConstraintValidatorContext context) {
        if (pageable == null) {
            return true;
        }
        Sort sortBy = pageable.getSort();
        if (sortBy.isUnsorted()) {
            return true;
        }
        for (Sort.Order order: sortBy) {
            if (!order.getProperty().equals("id")) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(String.format(PROPERTY_NOT_FOUND_MESSAGE, order.getProperty(), "id"))
                        .addConstraintViolation();
                return false;
            }
        }
        return true;
    }
}
