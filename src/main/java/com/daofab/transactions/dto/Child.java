package com.daofab.transactions.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

/**
 * Database Table Child's single row object depiction
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Child {

    @Id
    @NonNull
    private Long id;

    @NonNull
    private Long parentId;

    @NonNull
    private Long paidAmount;

    @ManyToOne
    @JoinColumn(name = "parentId", insertable=false, updatable=false)
    private Parent parent;
}
