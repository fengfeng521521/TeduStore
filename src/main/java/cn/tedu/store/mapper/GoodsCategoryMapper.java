package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {
	/*
	 * MyBatis中传参只能传一个，如果传入参数有多个，一般采用添加注解的方式解决
	 */
	/**
	 * 查询商品分类信息，
	 * @param parentId 当前父级id
	 * @param offset 偏移量 ：分页查询起始值
	 * @param count 数量
	 * @return 返回二级分类和三级分类的集合
	 */
	List<GoodsCategory> selectGoodsCategoryByParentId(@Param("parentId") Integer parentId,
			@Param("offset") Integer offset,@Param("count") Integer count);
	

}
