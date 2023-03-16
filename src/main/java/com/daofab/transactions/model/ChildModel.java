package com.daofab.transactions.model;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;


/**
 * Class to map database object to view model
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ChildModel extends RepresentationModel<ChildModel> {
    @Id
    @NonNull
    private Long id;

    /**
     * Derived from parent relation in DB
     */
    @NonNull
    private String sender;

    /**
     * Derived from parent relation in DB
     */
    @NonNull
    private String receiver;

    /**
     * Derived from parent relation in DB
     */
    @NonNull
    private Long totalAmount;

    @NonNull
    private Long paidAmount;
}
