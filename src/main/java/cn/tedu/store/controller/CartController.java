package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.vo.CartVo;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Resource
	private ICartService cartService;
	
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,ModelMap map) {
		//1.业务层方法，返回集合
		List<CartVo> listVo = cartService.getCartByUid(this.getId(session));
		//2.把集合添加到map
		map.addAttribute("listVo", listVo);
		//3.return "cart"
		return "cart";
	}

	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(HttpSession session,String goodsId,Integer num){
		ResponseResult<Void> rr =
				new ResponseResult<Void>();
		Cart cart = new Cart();
		cart.setUid(this.getId(session));
		cart.setNum(num);
		cart.setGoodsId(goodsId);
		cartService.addCart(cart);
		rr.setState(1);
		rr.setMessage("添加购物车成功");
		return rr;
	}
	
	@RequestMapping("/deleteBatchById.do")
	public String deleteBatchById(Integer[] ids) {
		//1.调用业务层方法
		cartService.deleteBatchById(ids);
		//2.重定向
		return "redirect:../cart/showCart.do";
	}
	
	@RequestMapping("/deleteById.do")
	public String deleteById(Integer id) {
		cartService.deleteById(id);
		return "redirect:../cart/showCart.do";
	}
	
	@RequestMapping("/updateNum.do")
	@ResponseBody
	public ResponseResult<Void> updateNum(Integer id,Integer num){
		ResponseResult<Void> rr = 
				new ResponseResult<Void>();
		cartService.updateNum(id, num);
		rr.setState(1);
		rr.setMessage("修改保存成功");
		return rr;
		
	}
	
}
