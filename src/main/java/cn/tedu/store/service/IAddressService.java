package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface IAddressService {
	
	/**
	 * 添加用户地址
	 * @param address
	 */
	void addAddress(Address address);

	/**
	 * 通过uid查询该用户所有收货地址
	 * @param uid
	 * @return
	 */
	List<Address> getAddressByUid(Integer uid);
	
	/**
	 * 修改地址列表默认值
	 * @param uid
	 * @param id
	 */
	void setDefault(Integer uid,Integer id);
	
	/**
	 * 通过id获取地址对象
	 * @param id
	 * @return
	 */
	Address getAddressById(Integer id);
	
	/**
	 * 修改地址
	 * @param address
	 */
	void updateAddress(Address address);
	
	/**
	 * 根据id删除对应的地址数据
	 * @param id
	 */
	void deleteAddressById(Integer id);
	
}
