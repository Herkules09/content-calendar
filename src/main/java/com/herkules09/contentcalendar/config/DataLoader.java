package com.herkules09.contentcalendar.config;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.herkules09.contentcalendar.model.Content;
import com.herkules09.contentcalendar.service.ContentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

import java.io.InputStream;


@Component
public class DataLoader implements CommandLineRunner {

    private final ContentService contentService;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentService contentService, ObjectMapper objectMapper) {
        this.contentService = contentService;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        try (InputStream inputStream= TypeReference.class.getResourceAsStream("/data/content.json")){
            contentService.saveAll(objectMapper.readValue(inputStream,new TypeReference<List<Content>>(){}));
        }
    }
}
