package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController{

	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId,Integer page,ModelMap map) {
		//超链接时，page为null，默认设置page为1；
		if (page==null) {
			page=1;
		}
		//计算得到偏移量
		int offset = (page-1)*12;
		//获取第一页数据
		List<Goods> goodsList = goodsService.getGoodsByCategoryId(categoryId, offset, 12);
		Integer count = goodsService.getCount(categoryId);
		//把记录分多少页添加到map
		int pageSize = count%12 == 0 ? count/12 : count/12 + 1;
		//把集合添加到ModelMap中
		map.addAttribute("goodsList", goodsList);
		map.addAttribute("count", count);
		map.addAttribute("pageSize", pageSize);
		map.addAttribute("categoryId", categoryId);
		map.addAttribute("curPage", page);
		return "search";
	}
	
	@RequestMapping("/showProductInfo")
	public String showProductInfo(String  goodsId,ModelMap map) {
		Goods product = goodsService.getGoodsById(goodsId);
		map.addAttribute("product", product);
		
		return "product_details";
	}
	
	
}
