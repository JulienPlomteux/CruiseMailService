package com.plomteux.cruisemailservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
public class CruiseService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public String callApiAndReturnText(String url) {
        String response = restTemplate.getForObject(url, String.class);
        try {
            Object json = objectMapper.readValue(response, Object.class);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        } catch (Exception e) {
            log.error("Error formatting JSON", e);
            return response;
        }
    }
}
