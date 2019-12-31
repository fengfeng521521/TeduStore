import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestMapper {
	//IOC：控制权的转移（创建对象的控制权限转交给第三方框架spring容器控制创建）
	//需要将配置文件传递给容器来管理创建对象；
	private AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext("spring-dao.xml");
	private UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
	
	@Test
	public void testSelectById() {
		Integer id = 13;
		User user = userMapper.selectUserById(id);
		System.out.println(user);
		ac.close();
	}
	
	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId(1);
		user.setUsername("huchao");
		user.setPassword("admin1");
		user.setPhone("17839748611");
		user.setGender(0);
		user.setEmail("xy_huchao@163.com");
		user.setModifiedUser(user.getUsername());
		user.setModifiedTime(new Date());
		userMapper.updateUser(user);
		ac.close();
	}
	
	@Test

	public void testEmail() {
		String email = "xy_huchao@163.com";
		Integer num = userMapper.selectByEmail(email);
		System.out.println(num);
		ac.close();
	}
	
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setUsername("huchao12");
		user.setPassword("admin");
		user.setEmail("xy_huchao@163.com");
		user.setPhone("17839748611");
		
		userMapper.insertUser(user);
		ac.close();
	}

	@Test
	public void testSelectUserByUsername() {
		String username = "huchao";
		User user = userMapper.selectUserByUsername(username);
		System.out.println(user);
	}
}
