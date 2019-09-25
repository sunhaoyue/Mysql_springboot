package com.wantwant.service.impl;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @program: Mysql_springboot
 * @description: 钉钉验证登录接口
 * @author: Sunhaoyue
 * @create: 2019/09/24 16:34
 */
@Service("DingTalkClient")
public class DingTalkClient {
    public String client(String url, HttpMethod method, MultiValueMap<String,String> params){
        RestTemplate template=new RestTemplate();
        ResponseEntity<String> response1=template.getForEntity(url,String.class);
        return response1.getBody();
    }
}
