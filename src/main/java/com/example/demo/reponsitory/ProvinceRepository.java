package com.example.demo.reponsitory;

import com.example.demo.model.Province;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author luogeng.szq
 * @version $$Id:ProvinceRepository.java, v0.1 2018/1/3 下午8:41 Exp$$
 **/
public interface ProvinceRepository extends Repository<Province, Long> {

    /**
     * @param url
     * @return
     */
    @Query(value = "from Province u where u.url=:url")
    List<Province> findByUrl(@Param(value = "url")String url);
}
