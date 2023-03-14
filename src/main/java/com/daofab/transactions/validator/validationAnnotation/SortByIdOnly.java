package com.daofab.transactions.validator.validationAnnotation;

import com.daofab.transactions.validator.ParentSortByValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * Annotation to validate sort by parameter is restricted to only ID
 */
@Documented
@Target({ANNOTATION_TYPE, TYPE, FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ParentSortByValidator.class})
public @interface SortByIdOnly {

    String message() default "Only sort by ID is allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Specify an array of fields that are allowed.
     *
     * @return the allowed sort fields
     */
    String[] value() default {"id"};
}
