
package com.mon.miaosha.controller;


import com.mon.miaosha.domain.User;
import com.mon.miaosha.result.CodeMsg;
import com.mon.miaosha.result.Result;
import com.mon.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.Transient;

@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String helloWorld(){
        return "hello";
    }

//controller输出的两种方式
//一：rest api json输出
    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello(){

        return Result.success("hello,mon");
    }

    @RequestMapping("/error")
    @ResponseBody
    public Result<String> error(Model model){
        return  Result.error(CodeMsg.server_error);
    }

//二：输出页面模板名称
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {

        model.addAttribute("name","mon");
        return "hello";
    }


//测试 mybatis，数据库等配置
    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User>  dbGet() {
        User user=userService.getById(1);

        return Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean>   dbTX() {

        userService.tx();
        return Result.success(true);
    }
}
