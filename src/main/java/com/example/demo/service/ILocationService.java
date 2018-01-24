package com.example.demo.service;

import com.example.demo.model.Province;
import com.example.demo.model.University;

import java.util.List;

/**
 * @author luogeng.szq
 * @version $$Id:ILocationService.java, v0.1 2018/1/3 上午10:33 Exp$$
 **/
public interface ILocationService {

    /**
     * @return
     */
    List<Province> findAllProvinces();

    List<Province> batchInsertProvinces(List<Province> provinces);

    List<University> findAllUniversities();

    List<University> batchInsertUniversities(List<University> universities);

    List<University> getUniversityByParam(University university);

    List<Province> findByUrl(String url);
}
