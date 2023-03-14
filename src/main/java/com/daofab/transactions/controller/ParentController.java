package com.daofab.transactions.controller;

import com.daofab.transactions.assembler.ParentModelAssembler;
import com.daofab.transactions.dto.Parent;
import com.daofab.transactions.model.ParentModel;
import com.daofab.transactions.service.ParentService;
import com.daofab.transactions.validator.validationAnnotation.SortByIdOnly;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/parents")
@Validated
public class ParentController {
    private static final int PAGE_SIZE = 2;

    @Autowired
    private ParentService parentService;

    @Autowired
    private ParentModelAssembler parentModelAssembler;

    @Autowired
    private PagedResourcesAssembler<Parent> pagedParentAssembler;

    @GetMapping()
    public PagedModel<ParentModel> getPaginated(@SortByIdOnly() @PageableDefault(sort = "id", size = PAGE_SIZE) Pageable pageable) {
        Page<Parent> parentPage = parentService.getPaginatedParents(pageable);
        // Convert DTO to model and populate hypermedia info
        return pagedParentAssembler.toModel(parentPage, parentModelAssembler);
    }
}
