package com.brano.democp.service;

public interface EmailSenderService {

    void sendEmail(String toEmail, String body, String subject);

}
