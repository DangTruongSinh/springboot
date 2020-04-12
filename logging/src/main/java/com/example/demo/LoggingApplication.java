package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.MyService;

@SpringBootApplication
public class LoggingApplication implements CommandLineRunner{
	
	private static final Logger logger = LogManager.getLogger(LoggingApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LoggingApplication.class, args);
	}
	@Autowired
	MyService myService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		myService.testLog();
		logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        //sendEmail();
//        logger.fatal("Damn! Fatal error. Please fix me.");
	}


}
