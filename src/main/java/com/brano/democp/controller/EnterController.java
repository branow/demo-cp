package com.brano.democp.controller;

import com.brano.democp.entity.User;
import com.brano.democp.entity.VerificationToken;
import com.brano.democp.event.EmailVerificationEvent;
import com.brano.democp.exception.ExpirationTimeException;
import com.brano.democp.model.UserModel;
import com.brano.democp.service.UserService;
import com.brano.democp.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EnterController {

    private final UserService userService;
    private final VerificationTokenService verificationTokenService;
    private final ApplicationEventPublisher publisher;

    @Autowired
    public EnterController(UserService userService, VerificationTokenService verificationTokenService, ApplicationEventPublisher publisher) {
        this.userService = userService;
        this.verificationTokenService = verificationTokenService;
        this.publisher = publisher;
    }

    @GetMapping("/register")
    public String registerUser() {
        return "registration.html";///return only string (not html page)
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.register(userModel);
        mailVerificationToken(user, request);
        return "A link to confirm your registration has been sent to your email";
    }

    @GetMapping("/confirm-registration")
    public String confirmRegistration(@RequestParam("token") String token) {
        try {
            User user = userService.enableUser(token);
            return "user (" + user.getUserName() + ") was enabled";
        } catch (ExpirationTimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/resend-token")
    public String resendVerificationToken(@RequestParam("token") String oldToken, final HttpServletRequest request) {
        VerificationToken token = verificationTokenService.findByToken(oldToken);
        verificationTokenService.delete(token);
        mailVerificationToken(token.getUser(), request);
        return "A link has been sent to your email";
    }


    private void mailVerificationToken(final User user, final HttpServletRequest request) {
        String url = applicationUrl(request) + "/confirm-registration";
        EmailVerificationEvent event = new EmailVerificationEvent(user, url);
        publisher.publishEvent(event);
    }


    private String applicationUrl(final HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" +
                request.getServerPort() + request.getContextPath();
    }

}
