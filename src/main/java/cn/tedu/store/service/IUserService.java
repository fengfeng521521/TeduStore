package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	
	/**
	 * 实现用户注册 
	 * @param user 用户对象
	 */
	void register(User user);
	
	/**
	 * 验证邮箱是否被占用
	 * @param email 用户邮箱
	 * @return 没有被占用返回true，否则返回false
	 */
	boolean checkEmail(String email);
	
	/**
	 * 验证电话号码是否被占用
	 * @param phone 用户电话
	 * @return 没有被占用返回true，否则返回false
	 */
	boolean checkPhone(String phone);
	
	/**
	 * 验证用户名是否存在
	 * @param username 用户名
	 * @return 如果用户名不存在，返回true，否则返回false
	 */
	boolean checkUsername(String username);
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 用户密码
	 * @return 登录成功返回user对象，否则抛异常
	 * @throws UserNotFoundException
	 * @throws PasswordNotMatchException
	 */
	User login(String username,String password);
	
	//也可以封装在user对象中，但是在处理业务的时候比较麻烦，这里直接传入五个参数
	/**
	 * 修改用户信息
	 * @param id 用户名
	 * @param username 修改的用户名
	 * @param gender 修改的性别
	 * @param email 修改的邮箱
	 * @param phone 修改的电话
	 * @throws UserNotFoundException
	 * @throws UserNameAlreadyExistException
	 */
	void updateUser(Integer id,String username,Integer gender,String email,String phone);//user(5个值)

	/**
	 * 通过用户名查询用户信息
	 * @param id 用户id
	 * @return 用户信息，有则返回user对象，否则返回null
	 */
	User getUserById(Integer id);
	
	/**
	 * 修改密码
	 * @param id 用户id
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @throws UserNotFoundException
	 * @throws PasswordNotMatchException
	 */
	void changePassword(Integer id,String oldPassword,String newPassword);
	
}
