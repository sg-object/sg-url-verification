package com.sg.verification.common.model;

import java.io.IOException;
import java.net.HttpURLConnection;
import lombok.Data;

@Data
public class UrlInfo {

	private int responseCode;
	
	private String contentType;
	
	private int contentLength;
	
	private boolean unknown;
	
	private boolean fileYn;
	
	private boolean screenYn;
	
	public UrlInfo(HttpURLConnection connection) throws IOException{
		this.responseCode = connection.getResponseCode();
		this.contentType = connection.getContentType();
		this.contentLength = connection.getContentLength();
		this.unknown = false;
		if("image/jpeg".equals(this.contentType) || "application/octet-stream".equals(this.contentType)){
			this.fileYn = true;
		}else{
			this.fileYn = false;
		}
		
		if(this.contentType != null && this.contentType.toLowerCase().contains("text/html")){
			this.screenYn = true;
		}else{
			this.screenYn = false;
		}
	}
	
	public UrlInfo(boolean unknown) {
		// TODO Auto-generated constructor stub
		this.unknown = unknown;
	}
}
