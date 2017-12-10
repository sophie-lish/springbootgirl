package com.liush.girl.basic.controller;

import com.liush.girl.basic.respository.GirlRespository;
import com.liush.girl.basic.po.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRespository girlRespository;

    /**
     * @return
     */
    @GetMapping("getGirlList")
    public List<Girl> girlList() {
        return girlRespository.findAll();
    }

    /**
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping("addGirl")
    public Girl addGirl(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girlRespository.save(girl);
        return girl;
    }

    //查询一个女生
    @GetMapping(value = "/findGirl/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRespository.findOne(id);
    }

    //更新
    @PutMapping(value = "/updateGirl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRespository.save(girl);
    }

    //删除
    @DeleteMapping(value = "/deleteGirl/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRespository.delete(id);
    }

    @GetMapping("getGirlByAge/{age}")
    public List<Girl> findGirlListByage(@PathVariable("age") Integer age) {
        return girlRespository.findByAge(age);
    }
}
