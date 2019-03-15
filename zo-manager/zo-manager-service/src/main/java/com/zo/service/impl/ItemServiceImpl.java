package com.zo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zo.common.entity.EasyUIDataGridResult;
import com.zo.common.utils.IDUtils;
import com.zo.common.utils.Result;
import com.zo.mapper.TbItemDescMapper;
import com.zo.mapper.TbItemMapper;
import com.zo.pojo.TbItem;
import com.zo.pojo.TbItemDesc;
import com.zo.pojo.TbItemExample;
import com.zo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;

	@Override
	public TbItem findItemById(Long id) {
	
		return itemMapper.selectByPrimaryKey(id);
	}

	
	//分页查询
	@Override
	public EasyUIDataGridResult findByPage(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		
		TbItemExample example =new TbItemExample();
		List<TbItem> items = itemMapper.selectByExample(example);
		
		PageInfo<TbItem> info = new PageInfo<>(items);
		
		EasyUIDataGridResult gridResult = new EasyUIDataGridResult();
		gridResult.setTotal(info.getTotal());
		gridResult.setRows(items);
		
		return gridResult;
	}


	//添加商品
	@Override
	public Result addItem(TbItem item,String desc) {
		//生成商品的id
		long itemId=IDUtils.genItemId();
		item.setId(itemId);
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		
		//添加商品信息到tb_item
		itemMapper.insert(item);
		
		//添加描述信息
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);	
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		
		itemDescMapper.insert(itemDesc);
		
		return Result.ok();
	}

}








