package com.sg.verification.common.view;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.view.AbstractView;
import com.sg.verification.common.builder.ScreenShotBuilder;

public class DownloadView extends AbstractView {

	private String url;
	
	public DownloadView(String url) {
		// TODO Auto-generated constructor stub
		this.url = url;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> arg0, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Set-Cookie", "fileDownload=true;");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + System.currentTimeMillis() + ".jpeg");
		response.setStatus(HttpStatus.OK.value());
		
		ScreenShotBuilder builder = new ScreenShotBuilder(response.getOutputStream());
		builder.screenShot(url);
	}

}
