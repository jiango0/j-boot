package com.jzc.spring.boot.event.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
