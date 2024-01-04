package com.plomteux.cruisemailservice;

import com.plomteux.cruisemailservice.configuration.TestMailConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ActiveProfiles("test")
@SpringBootTest
@ContextConfiguration(classes = {TestMailConfig.class})
class CruiseMailServiceApplicationTests {
    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> CruiseMailServiceApplication.main(new String[]{"--spring.profiles.active=test"}));
    }
}

