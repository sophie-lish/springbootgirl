package com.liush.girl.basic.controller;

import com.liush.girl.basic.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class GirlResponseBodyController {

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping("/response/body")
    public String getGirlInfo() {
        return girlProperties.toString();
    }

}
