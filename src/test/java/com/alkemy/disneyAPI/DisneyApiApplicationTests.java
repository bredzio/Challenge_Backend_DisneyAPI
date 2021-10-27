package com.alkemy.disneyAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class DisneyApiApplicationTests {

	@Test
	void contextLoads() {
	}
        
        @Autowired
        private JavaMailSender mailSender;
 
        @Test
        public void sendSimpleMail() throws Exception {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("brunoredzio@hotmail.com");
            message.setTo("brunoredzio@hotmail.com");
                     message.setSubject ("Asunto: Correo simple");
                     message.setText ("Prueba del contenido del correo");

            mailSender.send(message);
        }

}
