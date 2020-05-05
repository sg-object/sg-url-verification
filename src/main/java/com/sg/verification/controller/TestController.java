package com.sg.verification.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sg.verification.common.model.UrlInfo;
import com.sg.verification.common.view.DownloadView;
import com.sg.verification.service.VerificationService;

@Controller
public class TestController {

	@Autowired
	private VerificationService verificationService;
	
	@GetMapping("/")
	public String verification(){
		return "verification.html";
	}

	@GetMapping("/eduction")
	public String eduction(){
		return "eduction.html";
	}
	
	@GetMapping("/screen")
	public ModelAndView getScreenShot(String url) {
		return new ModelAndView(new DownloadView(url));
	}
	
	@GetMapping("/verification/info")
	@ResponseBody
	public UrlInfo getUrlInfo(String url){
		return verificationService.getUrlInfo(url);
	}
	
	@GetMapping("/eduction/msg")
	@ResponseBody
	public List<String> educeMessage(String message){
		return verificationService.educeMessage(message);
	}
}
