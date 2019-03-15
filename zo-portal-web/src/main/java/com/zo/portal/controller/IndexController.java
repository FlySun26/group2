package com.zo.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zo.content.service.ContentService;
import com.zo.pojo.TbContent;

@Controller
public class IndexController {
	
	@Autowired
	private ContentService contentService;
	
	@Value("${CONTEN_AD}")
	private Long CONTEN_AD;
	
	@RequestMapping("/index")
	public String showIndex(Model model)
	{
		//得到广告数据
		List<TbContent> contents = contentService.findContentsByCategoryId(CONTEN_AD);
		model.addAttribute("ad1List", contents);
		return "index";
	}

}



