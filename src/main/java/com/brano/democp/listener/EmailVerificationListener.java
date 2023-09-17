package com.brano.democp.listener;

import com.brano.democp.entity.VerificationToken;
import com.brano.democp.event.EmailVerificationEvent;
import com.brano.democp.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailVerificationListener implements ApplicationListener<EmailVerificationEvent> {

    private final VerificationTokenService verificationTokenService;

    @Autowired
    public EmailVerificationListener(VerificationTokenService verificationTokenService) {
        this.verificationTokenService = verificationTokenService;
    }

    @Override
    public void onApplicationEvent(EmailVerificationEvent event) {
        VerificationToken token = verificationTokenService.createToken(event.getUser());
        String link = event.getUrl() + "?token=" + token.getToken();
        System.out.println(link);
        //send verification link to email
    }
}
