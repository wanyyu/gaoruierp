package com.gaorui.controller;

import com.gaorui.entity.Import;
import com.gaorui.entity.Sale;
import com.gaorui.entity.Store;
import com.gaorui.entity.User;
import com.gaorui.service.ImportService;
import com.gaorui.service.MerchService;
import com.gaorui.service.SaleService;
import com.gaorui.service.StoreService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created
 * by Administrator on 2017/11/6 0006.
 */
@Controller
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private MerchService merchService;
    @Autowired
    private StoreService storeService;

    //销售单查询
    @RequestMapping(value = "/getAllSale.html",produces = "text/html;charset=utf-8")
    public String getAllSale(Sale sale, HttpServletRequest request){
        request.setAttribute("saleList",saleService.getAllSale());
        return "sale/query";
    }

    //跳转新增或修改页面
    @RequestMapping(value = "/toGetSale/{saleid}",produces = "text/html;charset=utf-8")
    public String toGet(HttpServletRequest request, HttpSession session, @PathVariable String saleid ){
        if (saleid != null&&!saleid.equals(0)) {
            request.setAttribute("sale",saleService.getSale(saleid));
        }
        request.setAttribute("merch",merchService.getAllMerch());
        return "sale/detail";
    }

    //新增修改
    @RequestMapping(value = "/edit.html",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String edit(HttpSession session,Sale sale){
        JSONObject result = new JSONObject();
        result.put("flag",false);
        //库存对象
        Store st=storeService.getStoreNum(sale.getMerch().getMerchid());
        if (sale==null) return result.toString();
        if(sale.getNum()>st.getNum()){
            result.put("msg","库存不足，请补充库存或重新输入");
            return result.toString();
        }else {
            if (sale.getSaleid() != null && sale.getSaleid() != "") {
                //销售表销售数量
                Integer num=saleService.getSale(sale.getSaleid()).getNum();
                //修改前货物状态
                Integer about=saleService.getSale(sale.getSaleid()).getAbout();
                if (saleService.updateSale(sale)) {
                    if (sale.getAbout() == 1) {
                        if (about == 0) {
                            st.setNum(st.getNum() - sale.getNum());
                            if (storeService.updateStore(st))
                                result.put("flag", true);
                        } else {
                            if (sale.getNum() > num) {
                                st.setNum(st.getNum() - (sale.getNum() - num));
                                if (storeService.updateStore(st))
                                    result.put("flag", true);
                            }
                            if (sale.getNum() < num) {
                                st.setNum(st.getNum() + (num - sale.getNum()));
                                if (storeService.updateStore(st))
                                    result.put("flag", true);
                            }
                            if (sale.getNum() == num) {
                                result.put("flag", true);
                            }

                        }

                    } else {
                        result.put("flag", true);
                    }
                }


            } else {
                Date date = new Date();
                sale.setDate(date);
                Integer ra = (int) ((Math.random() * 9 + 1) * 100000);
                sale.setSaleid(ra.toString());
                if (saleService.insertSale(sale))
                    if (sale.getAbout() == 1) {
                        st.setNum(st.getNum() - sale.getNum());
                        if (storeService.updateStore(st))
                            result.put("flag", true);

                    } else {
                        result.put("flag", true);
                    }
            }
            return result.toString();
        }
    }

    //删除
    @RequestMapping(value = "/delSale/{saleid}",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteSale(@PathVariable String saleid){
        JSONObject result = new JSONObject();
        result.put("flag",false);
        if (saleid==null ) return result.toString();
        if (saleService.deleteSale(saleid)) result.put("flag",true);
        return result.toString();

    }

}
