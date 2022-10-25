package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String from, String sub, String msgBody) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(sub);
            helper.setText(msgBody, true);
            /*helper.addAttachment("Abitur.pdf", new ByteArrayResource(content[0]));
            helper.addAttachment("Amine Tamar - Lebenslauf.pdf", new ByteArrayResource(content[1]));
            helper.addAttachment("Praktika - Informatik .pdf", new ByteArrayResource(content[2]));
            helper.addAttachment("Diplom -informatik.pdf", new ByteArrayResource(content[3]));
            helper.addAttachment("Deutsch B1 goethe institut Zertifikat   .pdf", new ByteArrayResource(content[4]));*/
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
