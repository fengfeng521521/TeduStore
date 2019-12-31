package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface CartMapper {
	/**
	 * 
	 * @param cart
	 */
	void insertCart(Cart cart);
	
	/**
	 * 根据用户id查询其购物车中的详情
	 * @param uid
	 * @return
	 */
	List<CartVo> selectCartByUid(Integer uid);
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteBatchById(Integer[] ids);
	
	/**
	 * 存储过程删除
	 * @param id
	 */
	void deleteById(Integer id);
	
	/**
	 * 更改购物车购买商品数量
	 * @param id
	 * @param num
	 */
	void updateNum(@Param("id") Integer id,@Param("num") Integer num);

}
