package cn.fengyu.ssm.web.items.controller;

import cn.fengyu.ssm.exception.AppException;
import cn.fengyu.ssm.web.items.po.ItemsCustom;
import cn.fengyu.ssm.web.items.po.ItemsQueryVo;
import cn.fengyu.ssm.web.items.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
// 为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
// 比如：商品列表：/items/queryItems.action
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    // 商品分类
    //itemtypes表示最终将方法返回值放在request中的key
    @ModelAttribute("itemtypes")
    public Map<String, String> getItemTypes() {

        Map<String, String> itemTypes = new HashMap<String, String>();
        itemTypes.put("101", "数码");
        itemTypes.put("102", "母婴");

        return itemTypes;
    }


    @RequestMapping("/queryItems")
    public ModelAndView queryItems(HttpServletRequest request,
                                   ItemsQueryVo itemsQueryVo) throws Exception {
        // 测试forward后request是否可以共享

        System.out.println(request.getParameter("id"));

        // 调用service查找 数据库，查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("items/itemsList");

        return modelAndView;

    }


    @RequestMapping(value = "/editItems", method = {RequestMethod.POST,
            RequestMethod.GET})
     public String editItems(Model model,
                            @RequestParam(value = "id") Integer items_id)
            throws Exception {

        // 调用service根据商品id查询商品信息
        ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
        //判断商品是否为空，根据id没有查询到商品，抛出异常，提示用户商品信息不存 在
//		if(itemsCustom == null){
//			throw new AppException("修改的商品信息不存在!");
//		}
        if (itemsCustom != null) {
            throw new AppException("修改商品信息已存在",299);
        }

        // 通过形参中的model将model数据传到页面
        // 相当于modelAndView.addObject方法
        model.addAttribute("items", itemsCustom);

        return "items/editItems";
    }


    @RequestMapping("/itemsView/{id}")
    public
    @ResponseBody
    ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception {

        //调用service查询商品信息
        ItemsCustom itemsCustom = itemsService.findItemsById(id);

        return itemsCustom;

    }

    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(Model model,
                                  Integer id,
                                 @Validated ItemsCustom itemsCustom,
                                  BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.out.println(allError);
                model.addAttribute("allErrors", allError);
                //可以直接使用model将提交pojo回显到页面
                model.addAttribute("items", itemsCustom);
                // 出错重新到商品修改页面
                return "items/editItems";
            }
        }

        // 调用service更新商品信息，页面需要将商品信息传到此方法
        itemsService.updateItems(id, itemsCustom);

        return "success";
    }

    // 批量删除 商品信息
    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id) throws Exception {

        // 调用service批量删除商品
        // ...

        return "success";

    }

    // 批量修改商品页面，将商品信息查询出来，在页面中可以编辑商品信息
    @RequestMapping("/editItemsQuery")
    public ModelAndView editItemsQuery(HttpServletRequest request,
                                       ItemsQueryVo itemsQueryVo) throws Exception {

        // 调用service查找 数据库，查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);

        modelAndView.setViewName("items/editItemsQuery");

        return modelAndView;

    }

    // 批量修改商品提交
    // 通过ItemsQueryVo接收批量提交的商品信息，将商品信息存储到itemsQueryVo中itemsList属性中。
    @RequestMapping("/editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo)
            throws Exception {

        return "success";
    }

}
