package com.daofab.transactions.eventListener;

import com.daofab.transactions.dto.Child;
import com.daofab.transactions.dto.Parent;
import com.daofab.transactions.service.ChildService;
import com.daofab.transactions.service.ParentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Event listener to populate data from resources into In-Mem SQL DB
 */
@Component
public class ApplicationStartListener {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationStartListener.class);

    @Value("${parent.data.location}")
    Resource parentResource;

    @Value("${child.data.location}")
    Resource childResource;

    @Autowired
    ParentService parentService;

    @Autowired
    ChildService childService;

    @EventListener(ApplicationReadyEvent.class)
    public void loadParentsToInMemoryDatabase() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<String, List<Parent>>> typeReference = new TypeReference<Map<String, List<Parent>>>(){};
        try {
            File jsonFile = parentResource.getFile();
            List<Parent> parents = mapper.readValue(jsonFile, typeReference).get("data");
            parentService.saveAll(parents);
            logger.info("Parents Loaded in In-Mem DB!");
        } catch (IOException e){
            logger.error("Unable to load parents data: " + e.getMessage());
            throw e;
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadChildrenToInMemoryDatabase() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<String, List<Child>>> typeReference = new TypeReference<Map<String, List<Child>>>(){};
        try {
            File jsonFile = childResource.getFile();
            List<Child> children = mapper.readValue(jsonFile, typeReference).get("data");
            childService.saveAll(children);
            logger.info("Children Loaded in In-Mem DB!");
        } catch (IOException e){
            logger.error("Unable to load children data: " + e.getMessage());
            throw e;
        }
    }
}
