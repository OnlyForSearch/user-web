package cn.fengyu.ssm.web.items.mapper;


import cn.fengyu.ssm.web.items.po.Items;

public interface ItemsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);



    Items selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);
}