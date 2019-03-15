package com.zo.content.service;

import java.util.List;

import com.zo.common.entity.EasyUITreeNode;
import com.zo.common.utils.Result;

public interface ContentCategoryService {
	
	//查询子分类
	List<EasyUITreeNode> findContentCategorys(long parentId);
	
	//添加分类
	Result addContentCategory(Long parentId, String name);
	

}
