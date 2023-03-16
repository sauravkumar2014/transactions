package com.daofab.transactions.eventListener;

import com.daofab.transactions.dto.Child;
import com.daofab.transactions.dto.Parent;
import com.daofab.transactions.repository.ChildRepository;
import com.daofab.transactions.repository.ParentRepository;
import com.daofab.transactions.service.ChildService;
import com.daofab.transactions.service.ParentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="/application-test.properties")
public class ApplicationStartListenerTest {

    private ApplicationStartListener applicationStartListener;

    @MockBean
    private ParentRepository parentRepository;

    @MockBean
    private ChildRepository childRepository;

    @SpyBean
    private ParentService spyParentService;

    @SpyBean
    private ChildService spyChildService;

    @BeforeAll
    public void setup() {
        applicationStartListener = new ApplicationStartListener();
    }

    @Test
    public void testParentLoadsCorrectData() {
        Parent dummyParent1 = new Parent(1L, "ABC", "XYZ", 200L);
        Parent dummyParent2 = new Parent(2L, "XYZ", "MNP", 100L);

        doNothing().when(spyParentService).saveAll(anyList());

        ArgumentCaptor<List<Parent>> captor = ArgumentCaptor.forClass(List.class);
        verify(spyParentService, times(1))
                .saveAll(captor.capture());

        assertThat(captor.getValue()).containsAll(Arrays.asList(dummyParent1, dummyParent2));
    }

    @Test
    public void testChildLoadsCorrectData() {
        Child dummyChild1 = new Child(2L, 1L, 50L);
        Child dummyChild2 = new Child(1L, 1L, 10L);

        doNothing().when(spyChildService).saveAll(anyList());

        ArgumentCaptor<List<Child>> captor = ArgumentCaptor.forClass(List.class);
        verify(spyChildService, times(1))
                .saveAll(captor.capture());

        assertThat(captor.getValue()).containsAll(Arrays.asList(dummyChild1, dummyChild2));
    }
}
