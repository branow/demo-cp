package com.brano.democp.listener;

import com.brano.democp.entity.User;
import com.brano.democp.entity.VerificationToken;
import com.brano.democp.event.EmailVerificationEvent;
import com.brano.democp.service.EmailSenderService;
import com.brano.democp.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailVerificationListener implements ApplicationListener<EmailVerificationEvent> {

    private final VerificationTokenService verificationTokenService;
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailVerificationListener(VerificationTokenService verificationTokenService, EmailSenderService emailSenderService) {
        this.verificationTokenService = verificationTokenService;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public void onApplicationEvent(EmailVerificationEvent event) {
        User user = event.getUser();
        VerificationToken token = verificationTokenService.createToken(user);
        String link = event.getUrl() + "?token=" + token.getToken();
//        emailSenderService.sendEmail(user.getEmail(),
//                "Please click on the link below to confirm verification\n" + link,
//                "Demo CP verification link");
        System.out.println(link);
    }
}
