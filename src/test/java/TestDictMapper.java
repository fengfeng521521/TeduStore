import java.util.List;


import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;


public class TestDictMapper {
	AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext("spring-dao.xml");
	DictMapper dictMapper = ac.getBean("dictMapper",DictMapper.class);
	
	@Test
	public void testSelect() {
		String provinceCode = "410000";
		System.out.println(dictMapper.selectProvinceNameByCode(provinceCode));
		String cityCode = "411500";
		System.out.println(dictMapper.selectCityNameByCode(cityCode));
		String areaCode = "411502";
		System.out.println(dictMapper.selectAreaNameByCode(areaCode));
		ac.close();
		
	}
	
	@Test
	public void testCity() {
		List<City> cities = dictMapper.selectCity("410000");
		for (City city : cities) {
			System.out.println(city);
		}
		ac.close();
	}
	
	@Test
	public void testSelectProvince() {
		List<Province>  provinces = dictMapper.selectProvince();
		for (Province province : provinces) {
			System.out.println(province);
		}
		ac.close();
	}

}
