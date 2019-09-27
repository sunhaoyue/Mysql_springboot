package com.wantwant.controller;

import com.alibaba.fastjson.JSONObject;
import com.wantwant.service.impl.DingTalkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: Mysql_springboot
 * @description: 验证钉钉登录控制
 * @author: Sunhaoyue
 * @create: 2019/09/24 15:42
 */

@Controller
public class LoginDDController {

    @Autowired
    DingTalkClient dingTalkClient;

    @RequestMapping(value = {"/loginDD"})
    public String getUserInfo(Model model, @RequestParam("code") String code){
        // 免登陆授权码
        System.out.println("免登陆授权码:"+code);
        String url="https://oapi.dingtalk.com/sso/getuserinfo?access_token="+this.getAccess_token()+"&code="+code;
        System.out.println(url);
        HttpMethod method=HttpMethod.GET;
        //???
        MultiValueMap<String,String> params=new LinkedMultiValueMap();
        String UserInfo=dingTalkClient.client(url,method,params);
        System.out.println("gituser"+UserInfo);

        JSONObject jsonObject=JSONObject.parseObject(UserInfo);
        if (jsonObject.get("errmsg")!= "无效的ssocode") {

            String corp_info= String.valueOf(jsonObject.get("corp_info"));
            String user_info= String.valueOf(jsonObject.get("user_info"));
            JSONObject corp_info_list=JSONObject.parseObject(corp_info);
            JSONObject user_info_list=JSONObject.parseObject(user_info);
            System.out.println(corp_info_list);
            System.out.println(user_info_list);

            //String corp_name = String.valueOf(corp_info_list.get("corp_name"));
            model.addAttribute("name", corp_info_list.get("corp_name"));
            System.out.println(corp_info_list.get("corp_name"));

            System.out.println(corp_info+"登录过中。。。!");
            return "index";
        }else{
            //登录失败，重新登录
            System.out.println("钉钉登录错误！");
            return "https://oa.dingtalk.com/index.htm#/microApp/microAppList";
        }
    }

    //获取应用后台免登的accessToken
    private String getAccess_token() {
        String url="https://oapi.dingtalk.com/sso/gettoken?corpid=dinga0487e9806384d71&corpsecret=5cXOQyNIz9tXHsyhkTV0dq_82BsBNcIV4WyxG5eMte5ur4QQtC25RMkbj3NKNEJw";
        HttpMethod method=HttpMethod.GET;
        MultiValueMap<String,String> params=new LinkedMultiValueMap();
        //dingTalkClient.client(url,method,params);
        //System.out.println(dingTalkClient.client(url,method,params));

        JSONObject jsonObject=JSONObject.parseObject(dingTalkClient.client(url,method,params));
        String access_token= String.valueOf(jsonObject.get("access_token"));
        System.out.println(access_token);
        return access_token;
    }

}
