package com.gaorui.controller;

import com.gaorui.entity.User;
import com.gaorui.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 跳转登录
     * */
    @RequestMapping(value = "/toLogin.html",produces = "text/html;charset=utf-8")
    public String toLogin(){
        return "user/login";
    }

    //登录功能
    @RequestMapping(value = "/doLogin.html",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getUser(User user, HttpServletRequest request, HttpSession session) {
        JSONObject result = new JSONObject(); // 返回JSON格式数据
        result.put("flag",false); // 默认登录失败
        // 验证用户名与密码是否为空
        if ((user.getLoginid()==null||user.getLoginid()=="")||(user.getPassword()==null||user.getPassword()=="")) {
            result.put("resMsg", "用户名和密码不允许为空");
            return result.toString();
        }
        User getuser=userService.getUser(user.getLoginid());
        // 判断用户名或密码是否正确
        if (getuser==null || !getuser.getPassword().equals(user.getPassword())){
            result.put("resMsg","用户名或密码不正确"); // 返回错误信息
            return result.toString();
        }
        else{
            session.setAttribute("user",getuser); // 将用户存放入session中
            result.put("flag", true); // 设置登录成功
            return result.toString();
        }
    }

    //进入首页
    @RequestMapping(value = "/getIndex.html",produces = "text/html;charset=utf-8")
    public String getIndex(){
        return "other/index";
    }





}
