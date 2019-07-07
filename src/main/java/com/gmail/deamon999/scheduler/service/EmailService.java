package com.gmail.deamon999.scheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    private int noOfQuickServiceThreads = 20;
    private ScheduledExecutorService quickService = Executors.newScheduledThreadPool(noOfQuickServiceThreads);


    public void sendASynchronousMailMime(MimeMessage mailMessage) throws MailException, RuntimeException {
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    mailSender.send(mailMessage);
                } catch (Exception e) {

                }
            }
        });
    }


    public void sendASynchronousMailSimple(SimpleMailMessage mailMessage) throws MailException, RuntimeException {
        quickService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    mailSender.send(mailMessage);
                } catch (Exception e) {

                }
            }
        });
    }

    public MimeMessage getMimeEmail() {
        return mailSender.createMimeMessage();
    }
}
