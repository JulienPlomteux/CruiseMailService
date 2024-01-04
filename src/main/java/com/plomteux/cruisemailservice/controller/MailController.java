package com.plomteux.cruisemailservice.controller;

import com.plomteux.cruisemailservice.controller.MailControllerApi;
import com.plomteux.cruisemailservice.scheduler.DailyEmailScheduler;
import com.plomteux.cruisemailservice.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Slf4j
public class MailController implements MailControllerApi {
    private final DailyEmailScheduler dailyEmailScheduler;

    @Override
    public ResponseEntity<Void> sendMail() {
        dailyEmailScheduler.triggerEmail();
        return ResponseEntity.ok().build();
    }
}
