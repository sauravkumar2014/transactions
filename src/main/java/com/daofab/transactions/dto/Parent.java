package com.daofab.transactions.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Comparator;
import java.util.List;

/**
 * Database Table Parent's single row object depiction
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Parent {

    @Id
    @NonNull
    private Long id;

    @NonNull
    private String sender;

    @NonNull
    private String receiver;

    @NonNull
    private Long totalAmount;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Parent toCompare)) {
            return false;
        }

        return toCompare.getId().equals(this.getId())
                && toCompare.getSender().equals(this.getSender())
                && toCompare.getReceiver().equals(this.getReceiver())
                && toCompare.getTotalAmount().equals(this.getTotalAmount())
                && toCompare.getChildren() == this.getChildren();
    }
}
