package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface IDictService {
	/**
	 * 获取省份的值
	 * @return 省的列表集合
	 */
	List<Province> getProvince();
	
	/**
	 * 根据省份编码获取城市数据
	 * @param provinceCode
	 * @return
	 */
	List<City> getCity(String provinceCode);
	
	/**
	 * 根据城市编号获取地区数据
	 * @param cityCode
	 * @return
	 */
	List<Area> getArea(String cityCode);

}
