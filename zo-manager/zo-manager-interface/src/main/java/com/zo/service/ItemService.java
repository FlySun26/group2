package com.zo.service;

import com.zo.common.entity.EasyUIDataGridResult;
import com.zo.common.utils.Result;
import com.zo.pojo.TbItem;

public interface ItemService {
	
	//根据商品id查询商品信息
	TbItem findItemById(Long id);
	
	//分页查询
	EasyUIDataGridResult  findByPage(Integer page, Integer rows);
	
	//添加商品
	Result addItem(TbItem item, String desc);

}








