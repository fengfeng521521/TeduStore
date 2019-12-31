import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;

public class TestAddressMapper {
	
	AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext("spring-dao.xml");
	AddressMapper am = ac.getBean("addressMapper",AddressMapper.class);
	
	@Test
	public void testUpdateAddress() {
		Address address = new Address();
		address.setUid(2);
		address.setRecvName("王五");
		address.setRecvProvince("410000");
		address.setRecvCity("411500");
		address.setRecvArea("411503");
		address.setRecvPhone("17839748611");
		address.setRecvDistrict("河南省信阳市师河区");
		address.setRecvAddress("信阳市火车站街道");
		address.setRecvTel("03764758");
		address.setRecvZip(464000);
		address.setRecvTag("家");
		address.setId(8);
		am.updateAddressById(address);
		ac.close();
	}
	
	@Test
	public void testUpdate() {
		Integer id = 5;
		am.setDefault(id);
		ac.close();
	}
	
	@Test
	public void testSelectAddressByUid() {
		Integer uid = 2;
		List<Address> addresses = am.selectAddressByUid(uid);
		for (Address address : addresses) {
			System.out.println(address);
		}
		ac.close();
	}
	
	@Test
	public void testAddress() {
		Address address = new Address();
		address.setUid(2);
		address.setRecvName("zhangsan");
		address.setRecvProvince("410000");
		address.setRecvCity("411500");
		address.setRecvArea("411503");
		address.setRecvPhone("17839748611");
		address.setRecvDistrict("河南省信阳市师河区");
		address.setRecvAddress("信阳市火车站街道");
		address.setRecvTel("03764758");
		address.setRecvZip(464000);
		address.setRecvTag("家");
		address.setIsDefault(1);
		address.setCreatedUser("user");
		address.setCreatedTime(new Date());
		address.setModifiedUser("modifieduser");
		address.setModifiedTime(new Date());
		am.insertAddress(address);
		ac.close();
	}
	
}
