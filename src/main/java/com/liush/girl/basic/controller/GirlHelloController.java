package com.liush.girl.basic.controller;

import com.liush.girl.basic.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/girl")
public class GirlHelloController {

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = {"/getGirlInfo", "/readGirlInfo"})
    public String getGirlInfo() {
        return girlProperties.toString();
    }

    @GetMapping(value = {"/getGirlInfoPathVariable/{id}"})
    public String getGirlInfo1(@PathVariable("id") Integer id) {
        return "id:" + id;
    }


    @GetMapping(value = {"/getGirlInfoParam"})
    public String getGirlInfo2(@RequestParam("id") Integer id) {
        return "id:" + id;
    }

    @GetMapping(value = {"/getGirlInfoParamRequired"})
    public String getGirlInfo3(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id:" + id;
    }

}
