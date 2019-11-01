
package com.mon.miaosha.controller;


import com.mon.miaosha.result.CodeMsg;
import com.mon.miaosha.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class SampleController {

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
}
