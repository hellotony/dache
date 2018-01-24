package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.demo.model.Province;
import com.example.demo.model.University;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/**
 * @author luogeng.szq
 * @version $$Id:HttpUtil.java, v0.1 2018/1/3 下午4:47 Exp$$
 **/
public class HttpUtil {

    private static final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        String result = sendGet("http://api.shadowvc.com/area/320000000000");

        Map map = JSON.parseObject(result, Map.class);
        JSONArray array = (JSONArray)map.get("subset");
        //Map<String, JSONArray> map = JSON.parseObject(result, Map.class);
        //
        //JSONArray array = map.get("list");
        //JSONObject b = (JSONObject)array.get(0);


        //Object b = map.get("list");
        //JSONArray j = JSONArray.parseArray(b);
        //j.size();
        System.out.println(1);

    }

    /**
     * HTTP GET请求
     * @param url
     * @return
     * @throws Exception
     */
    public static String sendGet(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //默认值我GET
        con.setRequestMethod("GET");

        //添加请求头
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    /**
     * HTTP POST请求
     * @param url
     * @return
     * @throws Exception
     */
    private static String sendPost(String url) throws Exception {

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //添加请求头
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        //String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        //发送Post请求
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        //wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}
