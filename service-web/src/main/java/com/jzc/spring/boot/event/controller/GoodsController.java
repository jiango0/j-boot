package com.jzc.spring.boot.event.controller;

import com.jzc.spring.boot.aspect.Web;
import com.jzc.spring.boot.param.WebInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsController {

    @RequestMapping(value = "/index")
    public String index () {
        return "index";
    }

    @RequestMapping(value = "/main")
    public ModelAndView main() {
        return new ModelAndView("main");
    }

    @Web
    @ResponseBody
    @RequestMapping(value = "web")
    public String webIndex(@RequestBody WebInfo webInfo) {
        return "";
    }

}
