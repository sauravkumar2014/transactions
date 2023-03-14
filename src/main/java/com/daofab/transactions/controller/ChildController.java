package com.daofab.transactions.controller;

import com.daofab.transactions.assembler.ChildModelAssembler;
import com.daofab.transactions.model.ChildModel;
import com.daofab.transactions.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/children")
public class ChildController {

    @Autowired
    private ChildService childService;

    @Autowired
    private ChildModelAssembler childModelAssembler;

    @GetMapping()
    public CollectionModel<ChildModel> getChildren(@RequestParam("parentId") Long parentId) {
        List<ChildModel> children = childService.getChildren(parentId).stream()
                .map(childModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(children,
                linkTo(methodOn(ChildController.class).getChildren(parentId))
                        .withSelfRel());
    }
}
