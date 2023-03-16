package com.daofab.transactions.assembler;

import com.daofab.transactions.dto.Child;
import com.daofab.transactions.dto.Parent;
import com.daofab.transactions.model.ParentModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class ParentModelAssemblerTest {

    private ParentModelAssembler parentModelAssembler;

    @Test
    public void testParentLoadsCorrectData() {
        Child dummyChild1 = new Child(2L, 1L, 50L);
        Child dummyChild2 = new Child(1L, 1L, 10L);
        Parent dummyParent = new Parent(1L, "ABC", "XYZ", 200L);
        dummyParent.setChildren(Arrays.asList(dummyChild1, dummyChild2));

        ParentModel expectedParent = new ParentModel(1L, "ABC", "XYZ", 200L, 60L);

        parentModelAssembler = new ParentModelAssembler();
        assertEquals(parentModelAssembler.toModel(dummyParent), expectedParent);
    }
}
