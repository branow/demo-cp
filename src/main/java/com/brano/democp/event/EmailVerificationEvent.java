package com.brano.democp.event;

import com.brano.democp.entity.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EmailVerificationEvent extends ApplicationEvent {

    private final User user;
    private final String url;

    public EmailVerificationEvent(User user, String url) {
        super(user);
        this.user = user;
        this.url = url;
    }
}
