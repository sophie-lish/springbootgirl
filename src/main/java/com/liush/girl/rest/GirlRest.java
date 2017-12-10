package com.liush.girl.rest;

import com.liush.girl.domain.Girl;
import com.liush.girl.domain.Result;
import com.liush.girl.reprository.GirlRepository;
import com.liush.girl.service.GirlService;
import com.liush.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlRest {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @PostMapping("/girl/add")
    public Girl girlAdd(Girl girl) {
        return girlRepository.save(girl);
    }

    @PostMapping("/girl/add1")
    public Girl girlAdd1(@RequestBody Girl girl) {
        return girlRepository.save(girl);
    }

    @PostMapping("/girl/add2")
    public Girl girlAdd2(@Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.err.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }

    @PostMapping("/girl/add3")
    public Result<Girl> girlAdd3(@Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return  ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return  ResultUtil.success(girlRepository.save(girl));

    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
