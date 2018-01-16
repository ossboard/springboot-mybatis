package com.konantech.spring.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ossboard
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(params = "!acton")
    public String defaultActon() {
        return "redirect:demo.do?acton=top";
    }

    @RequestMapping(params = "acton=top")
    public String top() throws Exception {
        return "demo/demo";
    }

}