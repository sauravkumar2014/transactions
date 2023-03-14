package com.daofab.transactions.repository;

import com.daofab.transactions.dto.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pattern to depict Parent Table in DB
 * NOTE: all generic methods of searching on fields are auto implemented by JpaRepository
 * For more info, https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
 */
@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {}
