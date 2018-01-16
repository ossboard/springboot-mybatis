package com.konantech.spring.controller.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class CustomController {


    @RequestMapping(value = "/custom", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }


    @ResponseBody
    @RequestMapping(value="/username/{@ResponseBody\n" +
            "    @RequestMapping(value=\"/userid/{id}\",method=RequestMethod.GET)\n" +
            "    public User get(@PathVariable int id) {\n" +
            "        return userService.selectUserById(id);\n" +
            "    }name}",method=RequestMethod.GET)
    public String test(@PathVariable String name) {
        return name;
    }

}