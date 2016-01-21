package cn.fengyu.ssm.web.items.service.impl;

import cn.fengyu.ssm.web.items.mapper.ItemsMapper;
import cn.fengyu.ssm.web.items.po.ItemsCustom;
import cn.fengyu.ssm.web.items.po.ItemsQueryVo;
import cn.fengyu.ssm.web.items.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fengyu
 *         2016-01-20.
 */
@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsVo) throws Exception {
        return itemsMapper.findItemsList(itemsVo);
    }
}
