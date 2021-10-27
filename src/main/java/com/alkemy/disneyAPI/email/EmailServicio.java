package com.alkemy.disneyAPI.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailServicio implements EmailEnvio{
    
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailServicio.class);

    private final JavaMailSender mailSender;
    
    @Override
    @Async
    public void envio(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirme su email");
            helper.setFrom("brunoredzio@hotmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("Fallo al envió del email", e);
            throw new IllegalStateException("Fallo al envió del email");
        }
    }
}
