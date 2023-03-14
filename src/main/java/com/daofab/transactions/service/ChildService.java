package com.daofab.transactions.service;

import com.daofab.transactions.dto.Child;
import com.daofab.transactions.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    /**
     * Saves all given children in child Table
     * @param children
     */
    public void saveAll(List<Child> children) {
        childRepository.saveAll(children);
    }

    /**
     * Gets list of children for parent sorted by Id
     * @param parentId Associated Parent's ID
     * @return List of Child DTOs
     */
    public List<Child> getChildren(Long parentId) {
        return childRepository.findAllByParentIdOrderByIdAsc(parentId);
    }
}
