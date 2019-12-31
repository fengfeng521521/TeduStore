package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	/**
	 * 新建地址
	 * @param address
	 */
	void insertAddress(Address address);
	
	/**
	 * 根据uid查询该用户的收货地址
	 * @param uid
	 * @return
	 */
	List<Address> selectAddressByUid(Integer uid);
	
	/**
	 * 根据uid设置所有地址is_default的值为0
	 * @param uid
	 * @return
	 */
	Integer setCancel(Integer uid);
	
	/**
	 * 根据id设置所点击选择的地址
	 * @param uid
	 * @return
	 */
	Integer setDefault(Integer id);
	
	/**
	 * 通过id获取对应的address对象
	 * @param id
	 * @return
	 */
	Address selectAddressById(Integer id);
	
	/**
	 * 修改地址信息
	 * @param address
	 */
	void updateAddressById(Address address);
	
	/**
	 * 通过id删除对应的数据
	 * @param id
	 */
	void deleteAddressById(Integer id);
	
	

}
