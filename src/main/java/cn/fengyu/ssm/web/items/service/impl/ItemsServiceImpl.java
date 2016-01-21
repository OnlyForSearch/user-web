package cn.fengyu.ssm.web.items.service.impl;

import cn.fengyu.ssm.web.items.po.Items;
import cn.fengyu.ssm.web.items.po.ItemsQueryVo;
import cn.fengyu.ssm.web.items.service.ItemsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fengyu
 *         2016-01-20.
 */
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

    /*@Resource
    private ItemsMapper itemsMapper;*/

    public List<Items> findItemsList(ItemsQueryVo itemsVo) {
        return null;
    }
}
