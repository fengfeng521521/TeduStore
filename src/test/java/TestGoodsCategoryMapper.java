import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;

public class TestGoodsCategoryMapper {
	AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext("spring-dao.xml");
	GoodsCategoryMapper goodsCategoryMapper = 
			ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
	@Test
	public void testSelectGoodsCategory() {
		List<GoodsCategory> list =
				goodsCategoryMapper.selectGoodsCategoryByParentId(161, 0, 3);
		for (GoodsCategory goodsCategory : list) {
			System.out.println(goodsCategory);
			Integer id = goodsCategory.getId();
			List<GoodsCategory> list2 =
					goodsCategoryMapper.selectGoodsCategoryByParentId(id, null,null);
			for (GoodsCategory goodsCategory2 : list2) {
				System.out.println(goodsCategory2);
			}
		}
		
		ac.close();
	}

}
