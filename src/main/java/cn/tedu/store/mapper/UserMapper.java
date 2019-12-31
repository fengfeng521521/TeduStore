package cn.tedu.store.mapper;

import cn.tedu.store.bean.User;

public interface UserMapper {
	
	/**
	 * 插入数据
	 * @param user 封装数据的对象
	 */
	void insertUser(User user);
	
	/**
	 * 根据用户名查询用户信息
	 * @param username 用户名
	 * @return 用户信息,如果有结果则返回该用户对象User，否则返回null
	 */
	User selectUserByUsername(String username);
	
	/**
	 * 通过邮箱查询数据
	 * @param email 用户邮箱
	 * @return 如果邮箱存在，则返回值>=1，否则，返回0
	 */
	Integer selectByEmail(String email);
	
	/**
	 * 通过电话号码查询数据
	 * @param phone 用户电话
	 * @return 如果电话号码已经存在，则返回值>=1,否则返回值为0
	 */
	Integer selectByPhone(String phone);
	
	/**
	 * 修改用户信息
	 * @param user 用户对象
	 */
	void updateUser(User user);
	
	/**
	 * 根据用户id查询用户信息
	 * @param id 用户id
	 * @return 用户信息
	 */
	User selectUserById(Integer id);

}
