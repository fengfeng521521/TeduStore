package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	
	/**
	 * 
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> selectGoodsByCategoryId(@Param("categoryId") Integer categoryId,
											@Param("offset") Integer offset,
											@Param("count") Integer count);
	
	/**
	 * 通过商品分类id查询商品数量
	 * @param categoryId
	 * @return 该分类商品下面共有商品数
	 */
	Integer selectCountByCategoryId(Integer categoryId);

	/**
	 * 通过商品id查询商品详情
	 * @param goodsId
	 * @return
	 */
	Goods selectGoodsById(String  goodsId);

}
