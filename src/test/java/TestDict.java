import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.Province;
import cn.tedu.store.service.IDictService;

public class TestDict {
	AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext("spring-service.xml","spring-dao.xml");
	IDictService dictService = ac.getBean("dictService",IDictService.class);
	
	@Test
	public void testGetArea() {
		List<Area> areas = dictService.getArea("410100");
		for (Area area : areas) {
			System.out.println(area);
		}
		ac.close();
	}
	
	@Test
	public void testGetprovince() {
		List<Province> provinces = dictService.getProvince();
		for (Province province : provinces) {
			System.out.println(province);
		}
		ac.close();
	}

}
