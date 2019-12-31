package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map) {
		/*
		 * 1.调用业务层方法，返回集合computerList
		 * 2.定义List<List<GoodsCategory>>二维集合 创建对象
		 * 3.遍历computerList集合，获取二级分类下的三级分类，返回list集合
		 * 4.将三级分类的集合添加到二维集合对象中
		 * 5.分别将两个集合设置到map中
		 */
		List<GoodsCategory> computerList =
				goodsCategoryService.getGoodsCategoryByParentId(161, 0, 3);
		List<List<GoodsCategory>> category161List =
				new ArrayList<List<GoodsCategory>>();
		for (GoodsCategory goodsCategory : computerList) {
			List<GoodsCategory> goodsCategories = 
					goodsCategoryService.getGoodsCategoryByParentId(goodsCategory.getId(), null, null);
			category161List.add(goodsCategories);
		}
		//显示热门商品
		List<Goods> goodsList = goodsService.getGoodsByCategoryId(163, 0, 3);
		//分别将两个集合设置到map中
		map.addAttribute("computerList",computerList);
		map.addAttribute("category161List", category161List);
		map.addAttribute("goodsList", goodsList);
		
		return "index";
	}

}
