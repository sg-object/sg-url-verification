package com.sg.verification.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sg.verification.common.model.UrlInfo;

@Service
public class VerificationService {

	@Autowired
	private UrlPatternService urlPatternService;
	
	public UrlInfo getUrlInfo(String spec){
		HttpURLConnection connection = null;
		try {
			URL url = new URL(spec);
			connection = (HttpURLConnection)url.openConnection();
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(6000);
			return new UrlInfo(connection);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new UrlInfo(true);
		}  catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			if(connection != null){
				connection.disconnect();
			}
		}
	}
	
	public List<String> educeMessage(String message){
		List<String> result = new ArrayList<>();
		Matcher matcher = urlPatternService.getMatcher(message);
		while(matcher.find()){
			result.add(message.substring(matcher.start(), matcher.end()));
		}
		return result;
	}
}
