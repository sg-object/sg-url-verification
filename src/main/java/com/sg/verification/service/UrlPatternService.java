package com.sg.verification.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlPatternService {

	@Value("${url.pattern.ip.v4}")
	private String IP_ADDRESS_V4;
	@Value("${url.pattern.protocol}")
	private String PROTOCOL;
	@Value("${url.pattern.01}")
	private String PATTERN_01;
	@Value("${url.pattern.02}")
	private String PATTERN_02;

	public Matcher getMatcher(String message){
		Pattern pattern = Pattern.compile("("+PROTOCOL+"?("+IP_ADDRESS_V4+"|"+PATTERN_01+"|"+PATTERN_02+")(\\:[0-9]{1,5})?([/?]([a-zA-z0-9가-희.;/?:@&=#~])*)?)");
		return pattern.matcher(message);
	}
}
