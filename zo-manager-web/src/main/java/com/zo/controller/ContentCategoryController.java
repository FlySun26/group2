package com.zo.controller;

import com.zo.common.entity.EasyUITreeNode;
import com.zo.common.utils.Result;
import com.zo.content.service.ContentCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	
	@Resource
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> findContentCategorys(@RequestParam(name="id",defaultValue="0")Long parentId)
	{
		System.out.println("contentcati");
		List<EasyUITreeNode> categorys = contentCategoryService.findContentCategorys(parentId);
		System.out.println(categorys.size());
		return categorys;
	}
	
	//添加分类
	@RequestMapping("/create")
	@ResponseBody
	public Result addContentCategory(Long parentId,String name){
		
		return contentCategoryService.addContentCategory(parentId, name);
	}

}










