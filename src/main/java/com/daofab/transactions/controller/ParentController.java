package com.daofab.transactions.controller;

import com.daofab.transactions.model.ParentModel;
import com.daofab.transactions.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/parents")
public class ParentController {
    private static final int PAGE_SIZE = 2;

    @Autowired
    private ParentService parentService;

    @GetMapping()
    public PagedModel<ParentModel> getPaginated(@PageableDefault(sort = "id", size = PAGE_SIZE) Pageable pageable) {
        return null;
    }
}
