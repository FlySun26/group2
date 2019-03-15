package com.zo.controller;

import com.zo.common.utils.FastDFSClient;
import com.zo.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PicUploadController {
	
	
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	@RequestMapping("/pic/upload")
	@ResponseBody    //mime   application/json   text/plain
	public String uploadPicture(MultipartFile uploadFile)
	{
		try {
			FastDFSClient fastclient=new FastDFSClient("classpath:conf/fast.conf");
			
			//得到上传的文件名
			String filename = uploadFile.getOriginalFilename();
			//得到上传文件的扩展名
			String extName = filename.substring(filename.lastIndexOf(".")+1);
			
			// http://192.168.25.133/M00/11/22/oweirowieurowfjlsjdfk.jpg
			String path = fastclient.uploadFile(uploadFile.getBytes(), extName);
			
			//拼接图片路径
			String url = IMAGE_SERVER_URL+path;
			
			Map map = new HashMap();
			map.put("error", 0);
			map.put("url", url);
			
			return JsonUtils.objectToJson(map);
			
		} catch (Exception e) {
			e.printStackTrace();
			Map map = new HashMap();
			map.put("error", 1);
			map.put("message", "上传失败");
			
			return JsonUtils.objectToJson(map);
		}
	}

}











