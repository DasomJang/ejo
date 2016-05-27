package ejo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import ejo.repository.vo.DownloadVO;

@Controller
@RequestMapping("/file")
public class DownloadController {
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/down.do")
	public void download(DownloadVO download, HttpServletResponse response) throws Exception {
		if (download.getFilePath() == null) {
			throw new Exception("File does not exist");
		}
		
		String uploadPath = servletContext.getRealPath("upload");
		System.out.println(uploadPath);
		uploadPath += download.getFilePath();
		File file = new File(uploadPath, download.getRealFileName());
		System.out.println(file);
		
		if(!file.exists()) {
			throw new Exception("File does not exist");			
		}
		
		if (download.getDraw() == null) {
			return;
		}
		
		response.setContentType("image/jpg");
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch(Exception e2) {
					throw new Exception(e2);
				}
			}
		}
		out.flush();
	}	
}
