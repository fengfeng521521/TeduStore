package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
@Service
public class AddressService implements IAddressService{

	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
	
	public void addAddress(Address address) {
		//调用dictMapper持久层三个selectxxName(),获取来的值用+连接起来
		//作为以下方法的参数，传进去
		String province = dictMapper.selectProvinceNameByCode(address.getRecvProvince());
		String city = dictMapper.selectCityNameByCode(address.getRecvCity());
		String area = dictMapper.selectAreaNameByCode(address.getRecvArea());
		
		address.setRecvDistrict(province+city+area);
		//调用
		List<Address> addresses = addressMapper.selectAddressByUid(address.getUid());
		//返回list，调用size方法，如果==0
		//设置is_default=1
		if (addresses.size()==0) {
			address.setIsDefault(1);
		}else {
			address.setIsDefault(0);
		}
		
		addressMapper.insertAddress(address);
		
	}

	public List<Address> getAddressByUid(Integer uid) {
		return addressMapper.selectAddressByUid(uid);
	}

	public void setDefault(Integer uid, Integer id) {
		//1.调用持久层方法，如果返回值为0，说明没有地址信息，数据不存在，抛出异常
		Integer urows = addressMapper.setCancel(uid);
		Integer irows = addressMapper.setDefault(id);
		if (urows == 0) {
			throw new RuntimeException("数据不存在");
		}
		if (irows == 0) {
			throw new RuntimeException("数据不存在"); 
		}
		
	}

	public Address getAddressById(Integer id) {
		return addressMapper.selectAddressById(id);
	}

	public void updateAddress(Address address) {
		//给address对象的recvDistrict设置值
		String province = dictMapper.selectProvinceNameByCode(address.getRecvProvince());
		String city = dictMapper.selectCityNameByCode(address.getRecvCity());
		String area = dictMapper.selectAreaNameByCode(address.getRecvArea());
		
		address.setRecvDistrict(province+city+area);
		//调用持久层方法
		addressMapper.updateAddressById(address);
		
	}

	public void deleteAddressById(Integer id) {
		addressMapper.deleteAddressById(id);
	}

}
