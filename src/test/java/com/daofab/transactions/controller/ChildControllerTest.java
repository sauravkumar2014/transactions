package com.daofab.transactions.controller;

import com.daofab.transactions.TransactionsApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@SpringBootTest(classes = {TransactionsApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="/application-test.properties")
public class ChildControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${child.response.ok}")
    Resource responseResource;

    private TestRestTemplate restTemplate;

    private String baseUrl;

    @BeforeAll
    public void envSetup() {
        restTemplate = new TestRestTemplate();
        baseUrl = "http://localhost:" + port;
    }

    @Test
    void whenValidInput() throws Exception {
        File file = responseResource.getFile();
        String expectedJsonResponse = new String(Files.readAllBytes(file.toPath()));

        ResponseEntity<String> actualJsonResponse = restTemplate.getForEntity(baseUrl + "/children?parentId=1", String.class);

        assertEquals(HttpStatusCode.valueOf(200), actualJsonResponse.getStatusCode());
        assertEquals(expectedJsonResponse, actualJsonResponse.getBody());
    }

    @Test
    void whenMissingParentId() {
        ResponseEntity<String> actualJsonResponse = restTemplate.getForEntity(baseUrl + "/children", String.class);

        assertEquals(HttpStatusCode.valueOf(400), actualJsonResponse.getStatusCode());
    }
}
