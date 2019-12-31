package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;

@Controller
@RequestMapping("/dict")
public class DictController extends BaseController{
	@Resource
	private IDictService dictService; 
	
	@RequestMapping("/getProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> getProvince(){
		//1创建rr对象
		ResponseResult<List<Province>> rr =
				new ResponseResult<List<Province>>();
		//2调用业务层方法，返回集合
		List<Province> provinces = dictService.getProvince();
		//3把集合设置为rr对象的属性
		rr.setState(1);
		rr.setMessage("获取省列表成功");
		rr.setData(provinces);
		//4返回rr
		return rr;
	}
	
	@RequestMapping("/getCity.do")
	@ResponseBody
	public ResponseResult<List<City>> getCity(String provinceCode){
		ResponseResult<List<City>> rr =
				new ResponseResult<List<City>>();
		List<City> cities = dictService.getCity(provinceCode);
		rr.setState(1);
		rr.setMessage("获取城市列表成功");
		rr.setData(cities);
		return rr;
	}
	
	@RequestMapping("/getArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> getArea(String cityCode){
		ResponseResult<List<Area>> rr =
				new ResponseResult<List<Area>>();
		List<Area> areas = dictService.getArea(cityCode);
		rr.setState(1);
		rr.setMessage("获取地区列表成功");
		rr.setData(areas);
		return rr;
	}
	
}
