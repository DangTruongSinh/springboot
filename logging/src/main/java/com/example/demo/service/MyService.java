package com.example.demo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	Logger logger = LogManager.getLogger(MyService.class);
	public void testLog()
	{
		logger.error("you have a error from service!");
	}
}
