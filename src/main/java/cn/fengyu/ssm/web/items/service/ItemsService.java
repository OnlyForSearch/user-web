package cn.fengyu.ssm.web.items.service;

import cn.fengyu.ssm.web.items.po.Items;
import cn.fengyu.ssm.web.items.po.ItemsQueryVo;

import java.util.List;


public interface ItemsService {

    List<Items> findItemsList(ItemsQueryVo itemsVo);
}
