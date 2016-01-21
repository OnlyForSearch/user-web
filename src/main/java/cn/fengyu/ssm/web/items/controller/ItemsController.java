package cn.fengyu.ssm.web.items.controller;

import cn.fengyu.ssm.web.items.po.Items;
import cn.fengyu.ssm.web.items.po.ItemsCustom;
import cn.fengyu.ssm.web.items.po.ItemsQueryVo;
import cn.fengyu.ssm.web.items.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fengyu
 * @since 2016-01-20
 * config:7 定义注解
 */
@Controller
public class ItemsController{

   @Autowired
    private ItemsService itemsService;

    @RequestMapping("/queryItems2")
    public ModelAndView queryItems2(HttpServletRequest request, HttpServletResponse response) throws Exception {

         List<ItemsCustom> itemsList = itemsService.findItemsList(new ItemsQueryVo());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList).setViewName("items/itemsList");
        return modelAndView;
    }
    /**
     * config:7_1定义方法注解
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Items> itemsList = new ArrayList<Items>();
        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(60002112f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
        items_1.setCreatetime(new Date());
        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");

        itemsList.add(items_1);
        itemsList.add(items_2);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList).setViewName("items/itemsList");
        return modelAndView;
    }
}
