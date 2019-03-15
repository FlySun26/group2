package com.zo.controller;

import com.zo.common.utils.Result;
import com.zo.content.service.ContentService;
import com.zo.pojo.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/content")
public class ContentController {
	
	@Resource
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	public Result addContent(TbContent content)
	{
		return contentService.addContent(content);
	}

}







