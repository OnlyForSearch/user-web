package cn.fengyu.ssm.web.items.service;

import cn.fengyu.ssm.web.items.po.ItemsCustom;
import cn.fengyu.ssm.web.items.po.ItemsQueryVo;

import java.util.List;


public interface ItemsService {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsVo) throws Exception;

    ItemsCustom findItemsById(Integer id)throws  Exception;

    void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;
}
