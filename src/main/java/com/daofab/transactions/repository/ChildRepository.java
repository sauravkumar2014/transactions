package com.daofab.transactions.repository;

import com.daofab.transactions.dto.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository pattern to depict Child Table in DB
 * NOTE: all generic methods of searching on fields are auto implemented by JpaRepository
 * For more info, https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
 */
public interface ChildRepository extends JpaRepository<Child, Long> {

    /**
     * Get list of all children associated with given Parent ID
     * @param ParentId Parent whose children have to be fetched
     * @return List of all children sorted by their IDs
     */
    List<Child> findAllByParentIdOrderByIdAsc(Long ParentId);
}
