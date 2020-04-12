package com.example.demo;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class SpringbootMailApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMailApplication.class, args);
	}
	@Autowired
    private JavaMailSender javaMailSender;
	@Override
	public void run(String... args) throws Exception {
		sendEmailWithAttachment();
		System.out.println("done!");
	}
	void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("emailsend");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }
	void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		
        helper.setTo("emailsend");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

		// hard coded a file path
        FileSystemResource file = 
        		new FileSystemResource(new File("C:\\Users\\16119\\Downloads\\rau_cu.jpg"));
        helper.addAttachment("image_vegetable.jpg", file);
//        helper.addAttachment("anh.png", new ClassPathResource("libc.pdf"));
        javaMailSender.send(msg);

    }
}
