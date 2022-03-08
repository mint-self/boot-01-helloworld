package com.xm.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mintFM
 * @create 2021-12-04 8:53
 * 开始编写业务代码
 */
//让return中的内容以字符串的形式写给浏览器
@ResponseBody
@RestController
public class HelloController {


    //请求处理方法
    //映射请求
    @RequestMapping("/hello")
    public String handle01() {
        return "Hello SpringBoot2";
    }
}
