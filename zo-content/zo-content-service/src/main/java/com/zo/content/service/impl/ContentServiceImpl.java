package com.zo.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zo.common.utils.Result;
import com.zo.content.service.ContentService;
import com.zo.mapper.TbContentMapper;
import com.zo.pojo.TbContent;
import com.zo.pojo.TbContentExample;
import com.zo.pojo.TbContentExample.Criteria;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public Result addContent(TbContent content) {
		
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		return Result.ok();
	}

	//根据内容分类的id查询内容
	@Override
	public List<TbContent> findContentsByCategoryId(Long categoryId) {
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		
		List<TbContent> contents = contentMapper.selectByExample(example);
		
		return contents;
	}

}
