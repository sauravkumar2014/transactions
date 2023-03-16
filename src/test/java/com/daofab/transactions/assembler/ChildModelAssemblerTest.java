package com.daofab.transactions.assembler;

import com.daofab.transactions.dto.Child;
import com.daofab.transactions.dto.Parent;
import com.daofab.transactions.model.ChildModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class ChildModelAssemblerTest {

    private ChildModelAssembler childModelAssembler;

    @Test
    public void testParentLoadsCorrectData() {
        Parent dummyParent = new Parent(1L, "ABC", "XYZ", 200L);
        Child dummyChild = new Child(2L, 1L, 50L);
        dummyChild.setParent(dummyParent);

        ChildModel expectedParent = new ChildModel(1L, "ABC", "XYZ", 200L, 50L);

        childModelAssembler = new ChildModelAssembler();
        assertEquals(childModelAssembler.toModel(dummyChild), expectedParent);
    }
}
