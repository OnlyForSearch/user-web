package cn.fengyu.ssm.web.items.mapper;


import cn.fengyu.ssm.web.items.po.ItemsCustom;
import cn.fengyu.ssm.web.items.po.ItemsQueryVo;

import java.util.List;

public interface ItemsCustomMapper {

  public  List<ItemsCustom> findItemsList(ItemsQueryVo itemsVo)throws Exception;


}