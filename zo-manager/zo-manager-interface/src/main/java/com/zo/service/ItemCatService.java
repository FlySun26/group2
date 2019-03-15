package com.zo.service;

import java.util.List;

import com.zo.common.entity.EasyUITreeNode;

//商品分类接口
public interface ItemCatService {
	
	List<EasyUITreeNode> findItemCats(Long id);

}
