package com.daofab.transactions.repository;

import com.daofab.transactions.dto.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {

    List<Child> findAllByParentIdOrderByIdAsc(Long ParentId);
}
