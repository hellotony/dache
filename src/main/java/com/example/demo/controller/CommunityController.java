package com.example.demo.controller;

import com.example.demo.model.Community;
import com.example.demo.model.Result;
import com.example.demo.reponsitory.CommunityJpaRepository;
import com.example.demo.service.ICommunityService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luogeng.szq
 * @version $$Id:CommunityController.java, v0.1 2018/2/6 下午4:39 Exp$$
 **/
@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private ICommunityService communityService;

    @Autowired
    private CommunityJpaRepository communityJpaRepository;


    @RequestMapping("/add")
    @JsonFormat
    public Result add(@Param("community")Community community) {
        if (community == null) {
            return Result.paramError();
        }
        if (StringUtils.isEmpty(community.getDescription())) {
            return Result.paramError();
        }

        Community c = communityJpaRepository.save(community);
        if (c == null) {
            return Result.executeError();
        }

        return Result.isOk();
    }


    @RequestMapping("/queryList")
    @JsonFormat
    private List<Community> queryList() {
        return communityJpaRepository.findAll();
    }


    @RequestMapping("/queryOne")
    @JsonFormat
    public Community queryOne(@Param("id")Long id) {
        if (id == null || id <= 0) {
            return null;
        }
        return communityJpaRepository.findOne(id);
    }
}
