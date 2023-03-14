package com.daofab.transactions.service;

import com.daofab.transactions.dto.Parent;
import com.daofab.transactions.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public void saveAll(List<Parent> parents) {
        parentRepository.saveAll(parents);
    }
}
