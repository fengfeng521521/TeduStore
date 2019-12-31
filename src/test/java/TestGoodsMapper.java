import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;

public class TestGoodsMapper {
	AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext("spring-dao.xml");
	GoodsMapper goodsMapper = ac.getBean("goodsMapper",GoodsMapper.class);
	
	@Test
	public void testGoodsByCategoryId() {
		List<Goods> gList = goodsMapper.selectGoodsByCategoryId(163, 0, 3);
		for (Goods goods : gList) {
			System.out.println(goods);
		}
		ac.close();
	}
	
}
