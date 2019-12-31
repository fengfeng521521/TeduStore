import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;

public class TestUser {
	
	private AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
	//private UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
	private IUserService userService = ac.getBean("userService",IUserService.class);
	
	@Test
	public void testChangePassword() {
		Integer id = 7;
		String oldPassword = "admin";
		String newPassword = "admin12";
		userService.changePassword(id, oldPassword, newPassword);
		ac.close();
	}
	
	@Test
	public void testUpdateUser() {
		Integer id = 12;
		String username = "huhudong";
		Integer gender = 1;
		String email = "huhu@qq.com";
		String phone = "13588866666";
		userService.updateUser(id, username, gender, email, phone);
		ac.close();
	}
	
	@Test
	public void testLogin() {
		String username = "huchao";
		String password = "admin";
		System.out.println(userService.login(username, password));
		ac.close();
	}
	
	@Test
	public void testCheckUsername() {
		String username = "huchao";
		boolean b = userService.checkUsername(username);
		System.out.println(b);
		ac.close();
	}
	
	@Test
	public void testCheckPhone() {
		String phone = "1380013800";
		boolean b = userService.checkEmail(phone);
		System.out.println(b);
		ac.close();
	}
	
	@Test
	public void testCheckEmail() {
		String email = "xy_huchao1@163.com";
		boolean b = userService.checkEmail(email);
		System.out.println(b);
		ac.close();
	}
	
	@Test
	public void testRegister() {
		User user = new User();
		user.setUsername("huchao2");
		user.setPassword("admin");
		user.setEmail("xy_huchao@163.com");
		userService.register(user);
		ac.close();
	}

}
