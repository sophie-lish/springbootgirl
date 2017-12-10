package com.liush.girl.basic.controller;

import com.liush.girl.basic.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GirlTemplateController {

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping("/index")
    public String getGirlInfo() {
        return "index";
    }



}
