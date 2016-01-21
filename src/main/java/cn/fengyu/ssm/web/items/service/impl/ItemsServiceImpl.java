package cn.fengyu.ssm.web.items.service.impl;

import cn.fengyu.ssm.web.items.mapper.ItemsCustomMapper;
import cn.fengyu.ssm.web.items.mapper.ItemsMapper;
import cn.fengyu.ssm.web.items.po.Items;
import cn.fengyu.ssm.web.items.po.ItemsCustom;
import cn.fengyu.ssm.web.items.po.ItemsQueryVo;
import cn.fengyu.ssm.web.items.service.ItemsService;
import org.springframework.beans.BeanUtils;
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
    private ItemsCustomMapper itemsCustomMapper;
    @Autowired
    private ItemsMapper itemsMapper;

    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsVo) throws Exception {
        return itemsCustomMapper.findItemsList(itemsVo);
    }

    @Override
    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        ItemsCustom itemsCustom = new ItemsCustom();
        BeanUtils.copyProperties(items,itemsCustom);


        return itemsCustom;
    }

    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom ) throws Exception {
        if (id == null) {
            throw new NullPointerException("id不能为空");
        }

        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }
}
