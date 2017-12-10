package com.liush.girl.basic.respository;

import com.liush.girl.basic.po.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRespository extends JpaRepository<Girl, Integer> {

    List<Girl> findByAge(Integer age);

}
