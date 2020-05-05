package com.sg.verification.common.builder;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScreenShotBuilder {

	private OutputStream outputStream;
	
	public ScreenShotBuilder(OutputStream outputStream) {
		// TODO Auto-generated constructor stub
		this.outputStream = outputStream;
	}
	
	public void screenShot(String url) {
		WebDriver webDriver = null;
		ChromeOptions options = new ChromeOptions();
		
		// mobile용 screenshot option
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Nexus 5");
		options.setExperimentalOption("mobileEmulation", mobileEmulation);
		
		Map<String, String> prefs = new HashMap<String, String>();
		prefs.put("intl.accept_languages", "ko,ko_KR");
		options.setExperimentalOption("prefs", prefs);
		
		options.addArguments("headless");
		options.addArguments("no-sandbox");
		options.addArguments("disable-dev-shm-usage");
		options.addArguments("lang=ko_KR");

		webDriver = new ChromeDriver(options);
		webDriver.get(url);
		webDriver.manage().window().maximize();

		try {
			// page loading이 끝나기 전에 screenshot을 취득하는 경우가 있어 sleep을 2초 설정 
			Thread.sleep(2000);
			
			byte[] bytes = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
			outputStream.write(bytes);
			outputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(webDriver != null){
					webDriver.close();
					webDriver.quit();
				}
				if(outputStream != null){
					outputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
