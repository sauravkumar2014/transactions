package com.daofab.transactions.service;

import com.daofab.transactions.dto.Parent;
import com.daofab.transactions.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    /**
     * Saves all given parents in parents Table
     * @param parents list of parent DTOs
     */
    public void saveAll(List<Parent> parents) {
        parentRepository.saveAll(parents);
    }

    /**
     * Gets list of parents for given page
     * @param pageable (Page number + Page size + Order By + Order by Direction) specification
     * @return Parent DTO List Page
     */
    public Page<Parent> getPaginatedParents(Pageable pageable) {
        return parentRepository.findAll(pageable);
    }
}
