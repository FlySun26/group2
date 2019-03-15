package com.zo.content.service;

import com.zo.common.utils.Result;
import com.zo.pojo.TbContent;

import java.util.List;

public interface ContentService {
	
	//添加内容
	Result  addContent(TbContent content);
	
	//根据内容分类的id查询内容
	List<TbContent> findContentsByCategoryId(Long categoryId);

}
