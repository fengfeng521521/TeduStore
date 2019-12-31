import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;

public class TestGoodsCategoryService {
	AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
	IGoodsCategoryService goodsCategoryService = 
			ac.getBean("goodsCategoryService",IGoodsCategoryService.class);
	@Test
	public void testSelectGoodsCategoryByParentId() {
		List<GoodsCategory> list = goodsCategoryService.getGoodsCategoryByParentId(161, 0, 3);
		System.out.println(list);
		ac.close();
	}
			
}
