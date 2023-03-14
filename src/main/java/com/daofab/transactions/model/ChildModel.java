package com.daofab.transactions.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
public class ChildModel extends RepresentationModel<ChildModel> {
    @Id
    @NonNull
    private Long id;

    @NonNull
    private String sender;

    @NonNull
    private String receiver;

    @NonNull
    private Long totalAmount;

    @NonNull
    private Long paidAmount;
}
