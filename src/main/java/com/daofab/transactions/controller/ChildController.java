package com.daofab.transactions.controller;

import com.daofab.transactions.model.ChildModel;
import com.daofab.transactions.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/children")
public class ChildController {

    @Autowired
    private ChildService childService;

    @GetMapping()
    public CollectionModel<ChildModel> getChildren(@RequestParam("parentId") Long parentId) {
        return null;
    }
}
