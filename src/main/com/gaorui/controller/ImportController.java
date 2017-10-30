package com.gaorui.controller;

import com.gaorui.entity.Import;
import com.gaorui.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
@Controller
@RequestMapping("/import")
public class ImportController {
    @Autowired
    private ImportService importService;

    //订单查询
    @RequestMapping(value = "/getAllImport.html",produces = "text/html;charset=utf-8")
    public String getAllImport(Import im, HttpServletRequest request){
        request.setAttribute("importList",importService.getAllImport(im));
        return "buy/query";
    }

    //获取订单详情
    @RequestMapping(value = "/getImport/{importid}",produces = "text/html;charset=utf-8")
    public String getImport( HttpServletRequest request,@PathVariable String importid){
        request.setAttribute("imp",importService.getImport(importid));
        return "buydetail/query";
    }


}
