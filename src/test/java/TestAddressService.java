
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.service.IAddressService;

public class TestAddressService {
	AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext("spring-service.xml","spring-dao.xml");
	IAddressService addressService = ac.getBean("addressService",IAddressService.class);
	
	@Test 
	public void testDeleteAddressById() {
		Integer id = 5;
		addressService.deleteAddressById(id);
		ac.close();
	}
	
	@Test
	public void testSelectById() {
		Integer id = 1;
		System.out.println(addressService.getAddressById(id));
		ac.close();
	}
	
	@Test
	public void testSetDefault() {
		Integer uid = 1;
		Integer id = 4;
		addressService.setDefault(uid, id);
		ac.close();
	}
	
	@Test
	public void testAddAddress() {
		Address address = new Address();
		address.setUid(2);
		address.setRecvName("利斯");
		address.setRecvProvince("410000");
		address.setRecvCity("411500");
		address.setRecvArea("411503");
		address.setRecvPhone("17839748611");
		address.setRecvDistrict("河南省信阳市平桥");
		address.setRecvAddress("火车站街道");
		address.setRecvTel("03764758");
		address.setRecvZip(464000);
		address.setRecvTag("家");
		addressService.addAddress(address);
		ac.close();
	}
}
