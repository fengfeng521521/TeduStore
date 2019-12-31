package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	
	/**
	 * 查询省份信息
	 * @return
	 */
	List<Province> selectProvince();
	
	/**
	 * 根据省份编码查询城市数据
	 * @param provinceCode
	 * @return
	 */
	List<City> selectCity(String provinceCode);
	
	/**
	 * 根据城市编号查询地区数据
	 * @param cityCode
	 * @return
	 */
	List<Area> selectArea(String cityCode);
	
	/**
	 * 通过省份编号查询省份名称
	 * @param provinceCode
	 * @return
	 */
	String selectProvinceNameByCode(String provinceCode);
	
	/**
	 * 通过城市编号查询城市名称
	 * @param cityCode
	 * @return
	 */
	String selectCityNameByCode(String cityCode);
	
	/**
	 * 通过区县编号查询区县名称
	 * @param areaCode
	 * @return
	 */
	String selectAreaNameByCode(String areaCode);
	

}
