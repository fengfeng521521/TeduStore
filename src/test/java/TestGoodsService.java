import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;

public class TestGoodsService {
	AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
	IGoodsService goodsService = ac.getBean("goodsService",IGoodsService.class);
	
	@Test
	public void testSelectGoodsById() {
		String goodsId ="10000042";
		System.out.println(goodsService.getGoodsById(goodsId));
		ac.close();
		
	}
	
	@Test
	public void testGetGoods() {
		List<Goods> goods = goodsService.getGoodsByCategoryId(163, 0, 3);
		for (Goods goods2 : goods) {
			System.out.println(goods2);
		}
		ac.close();
	}

}
