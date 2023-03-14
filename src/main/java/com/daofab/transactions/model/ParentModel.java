package com.daofab.transactions.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;


/**
 * Class to map database object to view model
 */
@Getter
@Setter
@NoArgsConstructor
public class ParentModel extends RepresentationModel<ParentModel> {

    @Id
    @NonNull
    private Long id;

    @NonNull
    private String sender;

    @NonNull
    private String receiver;

    @NonNull
    private Long totalAmount;

    /**
     * Derived from summation of child(one-to-many) relation in DB
     */
    @NonNull
    private Long totalPaidAmount;
}
