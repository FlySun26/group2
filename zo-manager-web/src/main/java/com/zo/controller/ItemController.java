package com.zo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zo.common.entity.EasyUIDataGridResult;
import com.zo.common.utils.Result;
import com.zo.pojo.TbItem;
import com.zo.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;//null
	
	@RequestMapping("/{id}")
	@ResponseBody
	public TbItem findById(@PathVariable Long id)
	{
		return itemService.findItemById(id);
	}
	
	
	//分页查询,easyui会给controller传递page,rows
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult findByPage(Integer page,Integer rows){
		
		return itemService.findByPage(page, rows);
		
	}
	
	
	//添加商品
	@RequestMapping("/save")
	@ResponseBody
	public Result addItem(TbItem item,String desc){
		return itemService.addItem(item, desc);
	   
	}

}













