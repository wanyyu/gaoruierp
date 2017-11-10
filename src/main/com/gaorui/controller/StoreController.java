package com.gaorui.controller;

import com.gaorui.entity.Import;
import com.gaorui.entity.Store;
import com.gaorui.service.MerchService;
import com.gaorui.service.StoreService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
@Controller
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private MerchService merchService;

    //查询全部库存
    @RequestMapping(value = "/getAllStore.html",produces = "text/html;charset=utf-8")
    public String getAllStroe(HttpServletRequest request){
        request.setAttribute("storeList", storeService.getAllStroe());
        return "store/query";
    }

    //获取库存
    @RequestMapping(value = "/getStore/{storeid}",produces = "text/html;charset=utf-8")
    public String getImport( HttpServletRequest request,@PathVariable String storeid){
        request.setAttribute("store",storeService.getStore(storeid));
        request.setAttribute("merch",merchService.getAllMerch());
        return "store/detail";
    }

    //修改库存信息
    @RequestMapping(value = "/updateStore.html",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateStore(Store sto){
        JSONObject result = new JSONObject();
        result.put("flag",false);
        if (sto==null) return result.toString();
        if(storeService.updateStore(sto))  result.put("flag",true);

        return result.toString();
    }

    //删除
    @RequestMapping(value = "/delStore/{storeid}",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteStore(@PathVariable String storeid){
        JSONObject result = new JSONObject();
        result.put("flag",false);
        if (storeid==null ) return result.toString();
        if (storeService.deleteStore(storeid)) result.put("flag",true);
        return result.toString();

    }
    //跳转新增页面
    @RequestMapping(value = "/toInsert.html",produces = "text/html;charset=utf-8")
    public String toInsert(HttpServletRequest request){
        request.setAttribute("merch",merchService.getAllMerch());
        return "store/add";

    }

    //新增
    @RequestMapping(value = "/insertStore.html",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String insertStore(Store sto){
        JSONObject result = new JSONObject();
        result.put("flag",false);
        if (sto==null) return result.toString();
        if(storeService.insertStore(sto))  result.put("flag",true);

        return result.toString();
    }




}
