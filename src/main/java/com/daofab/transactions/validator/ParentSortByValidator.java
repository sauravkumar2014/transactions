package com.daofab.transactions.validator;

import com.daofab.transactions.validator.validationAnnotation.SortByIdOnly;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Validator to validate given pageable object intends to sort only by ID
 */
public class ParentSortByValidator implements ConstraintValidator<SortByIdOnly, Pageable> {

    public static final String PROPERTY_NOT_FOUND_MESSAGE = "The following sort fields [%s] are not within the allowed fields. "
            + "Allowed sort fields are: [%s]";

    @Override
    public boolean isValid(Pageable pageable, ConstraintValidatorContext context) {
        // If no intention to sort/paginate, no problem
        if (pageable == null) {
            return true;
        }

        // If no intention to sort, no problem
        Sort sortBy = pageable.getSort();
        if (sortBy.isUnsorted()) {
            return true;
        }


        for (Sort.Order order: sortBy) {
            // If sort by value is not equal to ID
            if (!order.getProperty().equals("id")) {
                // Set custom error info
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(String.format(PROPERTY_NOT_FOUND_MESSAGE, order.getProperty(), "id"))
                        .addConstraintViolation();
                return false;
            }
        }
        return true;
    }
}
