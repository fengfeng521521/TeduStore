package cn.tedu.store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNameAlreadyExistException;
import cn.tedu.store.service.ex.UserNotFoundException;

@Service
public class UserService implements IUserService{
	
	@Resource
	private UserMapper userMapper;

	public void register(User user) {
		//1.调用selectUserByUserName(String username);返回User对象 user
		User u = userMapper.selectUserByUsername(user.getUsername());
		//2.判断user==null
		if (u==null) {
			//3.如果为空，调用insertUser(user)方法；
			userMapper.insertUser(user);
		}else {
			//4.如果不为空，抛出异常
			throw new UserNameAlreadyExistException("用户名被占用");
		}
	}

	public boolean checkEmail(String email) {
//		Integer num = userMapper.selectByEmail(email);
//		if (num==0) {
//			return true;
//		}else {
//			return false;
//		}
		//当邮箱在数据库中没有的时候返回true，可以使用，下面代码是对上面代码的优化
		return userMapper.selectByEmail(email)==0;
	}

	public boolean checkPhone(String phone) {
		return userMapper.selectByPhone(phone)==0;
	}

	public boolean checkUsername(String username) {
		User user = userMapper.selectUserByUsername(username);
		//如果user为空，则表示用户名不存在，可以使用，返回true
		return user==null;
	}
	
	/**
	 *用户登录
	 *1.调用持久层方法selectUserByUsername()
	 *2.判断user是否为空
	 *3.如果user!=null
	 *4.从user对象中取出密码，和参数password判断
	 *5.密码正确，返回user对象//因为登录成功之后需要在主页上显示用户信息
	 *6.密码不正确，抛出异常PasswordNotMatchException
	 *7.如果user==null，抛出异常UserNotFoundException 
	 */
	public User login(String username, String password) {
		User user = userMapper.selectUserByUsername(username);
		if (user!=null) {
			if (user.getPassword().equals(password)) {
				return user;
			}else {
				throw new PasswordNotMatchException("密码错误");
			}
		}else {
			throw new UserNotFoundException("用户未注册");
		}
	}

	public void updateUser(Integer id, String username,
			Integer gender, String email, String phone) {
		//1.调用selectUserById()返回user1
		//如果user1==null，抛出异常UserNotFoundException
		//如果user1！=null 
		//2.调用selectUserByUsername();返回user2
		//如果user2==null，user.setUserName(username)
		//如果user2!=null
		//3.user1.getUserName().equals(username)
		//做比较：结果为true：不做处理，为false，抛出异常
		//id ,username不能重复,gender,email,phone
		//updateUser(user);
		User user = new User();
		User user1 = userMapper.selectUserById(id);
		if (user1==null) {
			throw new UserNotFoundException("用户名不存在");
		}else {
			User user2 = userMapper.selectUserByUsername(username);
			if (user2==null||username.equals(user1.getUsername())) {
				user.setId(id);
				user.setUsername(username);
				user.setGender(gender);
				user.setEmail(email);
				user.setPhone(phone);
			}else {
					throw new UserNameAlreadyExistException("用户名已经被占用");
				}
			}
		userMapper.updateUser(user);
	}

	public User getUserById(Integer id) {
		return userMapper.selectUserById(id);
	}

	public void changePassword(Integer id, String oldPassword, String newPassword) {
		//1.调用selectUserById(),返回user对象
		//如果user==null，抛出异常，usernotfoundException
		//如果user！=null，那么user获取password，和参数列表里面的oldPassword做比较，
		//比较返回true，
		//User u = new User();
		//u.setId(),u.setPassword(newPassword);
		//修改密码updateUser(u);
		//4.如果返回false，抛出异常passwordnotMatchException
		User user = userMapper.selectUserById(id);
		if (user==null) {
			throw new UserNotFoundException("用户名不存在");
		}else {
			if (user.getPassword().equals(oldPassword)) {
				User u = new User();
				u.setId(id);
				u.setPassword(newPassword);
				System.out.println("duixiang u"+u);
				userMapper.updateUser(u);
			}else {
				throw new PasswordNotMatchException("密码输入错误，请重新输入");
			}
		}
		
		
	}

	

}
