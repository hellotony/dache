package com.example.demo.Impl;

import com.example.demo.model.Province;
import com.example.demo.model.University;
import com.example.demo.reponsitory.ProvinceJpaRepository;
import com.example.demo.reponsitory.ProvinceRepository;
import com.example.demo.reponsitory.UniversityJpaRepository;
import com.example.demo.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luogeng.szq
 * @version $$Id:LocationService.java, v0.1 2018/1/3 上午10:33 Exp$$
 **/
@Service
public class LocationService implements ILocationService {


    @Autowired
    private ProvinceJpaRepository provinceJpaRepository;

    @Autowired
    private UniversityJpaRepository universityJpaRepository;

    @Autowired
    private ProvinceRepository provinceRepository;


    @Override
    public List<Province> findAllProvinces() {
        return provinceJpaRepository.findAll();
    }

    @Override
    public List<Province> batchInsertProvinces(List<Province> provinces) {
        return provinceJpaRepository.save(provinces);
    }

    @Override
    public List<University> findAllUniversities() {
        return universityJpaRepository.findAll();
    }

    @Override
    public List<University> batchInsertUniversities(List<University> universities) {
        return universityJpaRepository.save(universities);
    }

    @Override
    public List<University> getUniversityByParam(University university) {

        return null;
    }

    @Override
    public List<Province> findByUrl(String url) {
        return provinceRepository.findByUrl(url);
    }

}
