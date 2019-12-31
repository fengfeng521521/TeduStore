package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.GoodsCategory;

public interface IGoodsCategoryService {
	/**
	 * 通过父级id获取商品分类信息
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<GoodsCategory> getGoodsCategoryByParentId(Integer parentId,Integer offset,Integer count);

}
