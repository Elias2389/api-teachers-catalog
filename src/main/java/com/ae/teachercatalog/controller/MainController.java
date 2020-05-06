package com.ae.teachercatalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        final String response = "Bienvenido al API :)";
        return response;
    }
}
