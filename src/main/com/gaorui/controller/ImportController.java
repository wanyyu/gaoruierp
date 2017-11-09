package com.gaorui.controller;

import com.gaorui.entity.Import;
import com.gaorui.entity.Merch;
import com.gaorui.entity.Store;
import com.gaorui.entity.User;
import com.gaorui.service.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
@Controller
@RequestMapping("/import")
public class ImportController {
    @Autowired
    private ImportService importService;
    @Autowired
    private MerchService merchService;
    @Autowired
    private ProfferService profferService;
    @Autowired
    private StoreService storeService;



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

    //跳转新增或修改页面
    @RequestMapping(value = "/toGet/{importid}",produces = "text/html;charset=utf-8")
    public String toGet(HttpServletRequest request,HttpSession session,@PathVariable String importid ){
        if (importid != null&&!importid.equals(0)) {
            request.setAttribute("imp",importService.getImport(importid));
        }
        request.setAttribute("merch",merchService.getAllMerch());
        request.setAttribute("proffer",profferService.getAllProffer());
        User user= (User) session.getAttribute("user");
        request.setAttribute("user1",user);
        return "buydetail/add";
    }


    //新增修改
    @RequestMapping(value = "/upOrIn.html",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String upOrIn(HttpSession session,Import im){
        JSONObject result = new JSONObject();
        result.put("flag",false);
        //库存对象
        Store st=storeService.getStoreNum(im.getMerch().getMerchid());
        if (im==null) return result.toString();
        if(im.getImportid()!=null&&im.getImportid()!=""){
            User user=(User)session.getAttribute("user");
            im.setUser(user);
            //进货表进货数量
            Integer num=importService.getImport(im.getImportid()).getNum();
            //修改前货物状态
            Integer about=importService.getImport(im.getImportid()).getAbout();
            if(importService.updateImport(im)){
                if(im.getAbout()==1) {
                    if (about == 0) {
                        st.setNum(im.getNum() + st.getNum());
                        if (storeService.updateStore(st))
                            result.put("flag", true);
                    } else {
                        //联动库存1
                        if (im.getNum() > num) {
                            st.setNum(st.getNum() + (im.getNum()-num));
                            if (storeService.updateStore(st))
                                result.put("flag", true);
                        }
                        //联动库存2
                        if (im.getNum() < num) {
                            st.setNum(st.getNum() -(num - im.getNum()) );
                            if (storeService.updateStore(st))
                                result.put("flag", true);
                        }
                        //联动库存3
                        if (im.getNum() == num) {
                            result.put("flag", true);
                        }
                    }
                }
                result.put("flag", true);
            }
        } else {
            Integer ra=(int)((Math.random()*9+1)*100000);
            im.setImportid(ra.toString());
            User user=(User)session.getAttribute("user");
            im.setUser(user);
            Date date=new Date();
            im.setImportdate(date);
            im.setTotalmoney(im.getNum()*im.getPrice());
            if(importService.insertImport(im))
                if(im.getAbout()==1){
                    Integer num = im.getNum() + st.getNum();
                    st.setNum(num);
                    if (storeService.updateStore(st))
                        result.put("flag", true);
                }
                result.put("flag",true);
        }
        return result.toString();
    }

    //删除
    @RequestMapping(value = "/delImport/{importid}",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteImport(@PathVariable String importid){
        JSONObject result = new JSONObject();
        result.put("flag",false);
        if (importid==null ) return result.toString();
        if (importService.deleteImport(importid)) result.put("flag",true);
        return result.toString();

    }

}
