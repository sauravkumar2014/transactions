package com.daofab.transactions.assembler;

import com.daofab.transactions.controller.ParentController;
import com.daofab.transactions.dto.Child;
import com.daofab.transactions.dto.Parent;
import com.daofab.transactions.model.ParentModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ParentModelAssembler extends RepresentationModelAssemblerSupport<Parent, ParentModel> {
    public ParentModelAssembler() {
        super(ParentController.class, ParentModel.class);
    }

    @Override
    public ParentModel toModel(Parent entity) {
        ParentModel model = new ParentModel();
        model.setId(entity.getId());
        model.setReceiver(entity.getReceiver());
        model.setSender(entity.getSender());
        model.setTotalAmount(entity.getTotalAmount());

        Long totalPaidAmount = Long.valueOf(0);
        for (Child child: entity.getChildren()) {
            totalPaidAmount += child.getPaidAmount();
        }
        model.setTotalPaidAmount(totalPaidAmount);

        return model;
    }
}
