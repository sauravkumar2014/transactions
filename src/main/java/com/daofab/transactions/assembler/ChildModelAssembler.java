package com.daofab.transactions.assembler;

import com.daofab.transactions.controller.ChildController;
import com.daofab.transactions.dto.Child;
import com.daofab.transactions.model.ChildModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

/**
 * Class to convert our DTO to model for a separation layer between Database and View layer
 */
@Component
public class ChildModelAssembler extends RepresentationModelAssemblerSupport<Child, ChildModel> {
    public ChildModelAssembler() {
        super(ChildController.class, ChildModel.class);
    }

    @Override
    public ChildModel toModel(Child entity) {
        ChildModel model = new ChildModel();
        model.setId(entity.getId());
        model.setReceiver(entity.getParent().getReceiver());
        model.setSender(entity.getParent().getSender());
        model.setTotalAmount(entity.getParent().getTotalAmount());
        model.setPaidAmount(entity.getPaidAmount());

        return model;
    }
}
