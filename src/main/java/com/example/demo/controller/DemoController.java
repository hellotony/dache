package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.demo.model.Province;
import com.example.demo.model.University;
import com.example.demo.service.ILocationService;
import com.example.demo.util.HttpUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author luogeng.szq
 * @version $$Id:DemoController.java, v0.1 2017/12/26 下午3:00 Exp$$
 **/

@RestController
public class DemoController {

    @Autowired
    private ILocationService iLocationService;

    @RequestMapping("/index")
    @JsonFormat
    public List<Province> test() {

        List<Province> provinces = new ArrayList<>();

        Province p = new Province();
        p.setName("shanghai");
        p.setUrl("http://www.baidu.com");
        provinces.add(p);
        Province p1 = new Province();
        p1.setName("guangzhou");
        p1.setUrl("http://www.baidu.com");
        provinces.add(p1);

        iLocationService.batchInsertProvinces(provinces);

        return iLocationService.findAllProvinces();
    }

    @RequestMapping("/school")
    @JsonFormat
    public List<University> getUniversities() {
        return iLocationService.findAllUniversities();
    }

    @RequestMapping("/province")
    @JsonFormat
    public List<Province> getProvinces() {
        List<Province> result = iLocationService.findByUrl("2");
        if (!CollectionUtils.isEmpty(result)) {

            String url = "http://api.shadowvc.com/area/";
            result.forEach(item -> {
                try {
                    List<Province> provinces = new ArrayList<>();
                    String province = HttpUtil.sendGet(url + item.getCode());

                    Map map = JSON.parseObject(province, Map.class);
                    JSONArray array = (JSONArray)map.get("subset");
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject b = (JSONObject)array.get(i);
                        Province p = new Province();
                        p.setCode((String)b.get("code"));
                        p.setName((String)b.get("name"));
                        p.setParent(item.getCode());
                        p.setUrl("3");
                        provinces.add(p);
                    }
                    iLocationService.batchInsertProvinces(provinces);
                    System.out.println(item.getName() +     "===============================================================");
                } catch (Exception e) {
                    e.printStackTrace();

                }
            });
        }

        return result;

    }


}
