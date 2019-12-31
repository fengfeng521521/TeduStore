package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface ICartService {
	/**
	 * 添加购物车
	 * @param cart
	 */
	void addCart(Cart cart);
	
	/**
	 * 根据用户id获取购物车列表
	 * @param uid
	 * @return
	 */
	List<CartVo> getCartByUid(Integer uid);
	
	/**
	 * 批量删除购物车
	 * @param ids
	 */
	void deleteBatchById(Integer[] ids);
	
	/**
	 * 单个删除购物车
	 * @param id
	 */
	void deleteById(Integer id);
	
	/**
	 * 将修改的商品购买数量存储到持久层
	 * @param id
	 * @param num
	 */
	void updateNum(Integer id,Integer num);

}
