package com.zo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo.common.entity.EasyUITreeNode;
import com.zo.mapper.TbItemCatMapper;
import com.zo.pojo.TbItemCat;
import com.zo.pojo.TbItemCatExample;
import com.zo.pojo.TbItemCatExample.Criteria;
import com.zo.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EasyUITreeNode> findItemCats(Long id) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		
		List<TbItemCat> itemCats = itemCatMapper.selectByExample(example);
		
		List<EasyUITreeNode> nodes = new ArrayList<>();
		for(TbItemCat itemCat:itemCats){
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(itemCat.getId());
			node.setText(itemCat.getName());
			node.setState(itemCat.getIsParent()?"closed":"open");
			
			nodes.add(node);
		}
		
		
		return nodes;
	}

}











