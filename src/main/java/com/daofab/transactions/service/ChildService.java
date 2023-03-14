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

    public void saveAll(List<Child> parents) {
        childRepository.saveAll(parents);
    }
}
