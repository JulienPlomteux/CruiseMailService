package com.plomteux.cruisemailservice.scheduler;

import com.plomteux.cruisemailservice.service.CruiseService;
import com.plomteux.cruisemailservice.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@AllArgsConstructor
public class DailyEmailScheduler {
    private final EmailService emailService;
    private final CruiseService cruiseService;

    @Value("${emailService.cruiseEndPoint}")
    private String cruiseEndPoint;

    @Value("${emailService.subject}")
    private String emailSubject;

    @Value("${emailService.recipient}")
    private String emailRecipient;

    @Scheduled(cron = "0 0 9 * * ?")
    public void triggerEmail() {
        String body = cruiseService.callApiAndReturnText(cruiseEndPoint);
           emailService.sendCruiseDealsEmail(emailRecipient, emailSubject, body);
    }
}