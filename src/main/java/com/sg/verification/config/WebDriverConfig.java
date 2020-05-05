package com.sg.verification.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {
	
	@Value("${webdriver.chrome.driver.path}")
	private String driver;
	
	@PostConstruct
	public void setChromeDriver(){
		System.setProperty("webdriver.chrome.driver", driver);
	}
}
