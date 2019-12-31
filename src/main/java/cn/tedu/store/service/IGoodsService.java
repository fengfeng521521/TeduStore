package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;

public interface IGoodsService {
	/**
	 * 根据商品分类id查询商品信息
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByCategoryId(Integer categoryId,Integer offset,Integer count);
	
	/**
	 * 通过商品分类id获取该类商品总数量
	 * @param categoryId
	 * @return
	 */
	Integer getCount(Integer categoryId);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Goods getGoodsById(String goodsId);

}
