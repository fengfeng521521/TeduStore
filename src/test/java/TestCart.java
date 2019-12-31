import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;

public class TestCart {
	AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
	CartMapper cartMapper = ac.getBean("cartMapper",CartMapper.class);
	
	@Test
	public void testDeleteBatchById() {
		Integer[] ids = {1,4};
		cartMapper.deleteBatchById(ids);
		ac.close();
	}
	
	@Test
	public void testInsertCart() {
		Cart cart = new Cart();
		cart.setUid(2);
		cart.setGoodsId("10000042");
		cart.setNum(2);
		cartMapper.insertCart(cart);
		ac.close();
	}

}
