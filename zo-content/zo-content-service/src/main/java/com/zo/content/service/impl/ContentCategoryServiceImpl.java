package com.zo.content.service.impl;

import com.zo.common.entity.EasyUITreeNode;
import com.zo.common.utils.Result;
import com.zo.content.service.ContentCategoryService;
import com.zo.mapper.TbContentCategoryMapper;
import com.zo.pojo.TbContentCategory;
import com.zo.pojo.TbContentCategoryExample;
import com.zo.pojo.TbContentCategoryExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	
	@Autowired
	private TbContentCategoryMapper  contentCategoryMapper;

	@Override
	public List<EasyUITreeNode> findContentCategorys(long parentId) {
		System.out.println("serverce运行了");
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbContentCategory> categorys = contentCategoryMapper.selectByExample(example);
		
		List<EasyUITreeNode> nodes = new ArrayList<>();
		for(TbContentCategory category:categorys){
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(category.getId());
			node.setText(category.getName());
			node.setState(category.getIsParent()?"closed":"open");
			
			nodes.add(node);
		}
		return nodes;
	}

	//添加分类
	@Override
	public Result addContentCategory(Long parentId, String name) {
		
		TbContentCategory contentCategory = new TbContentCategory();
		
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		contentCategory.setStatus(1);
		contentCategory.setSortOrder(1);
		contentCategory.setIsParent(false);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		
		contentCategoryMapper.insert(contentCategory);
		
		//判断父分类是不是父分类
		//得到父分类对象
		TbContentCategory fu = contentCategoryMapper.selectByPrimaryKey(parentId);
		
		//如果不是父分类需要改为是父分类
		if(!fu.getIsParent()){
			fu.setIsParent(true);
			//更新到数据库
			contentCategoryMapper.updateByPrimaryKey(fu);
		}
		
		
		return Result.ok(contentCategory);
	}

}












