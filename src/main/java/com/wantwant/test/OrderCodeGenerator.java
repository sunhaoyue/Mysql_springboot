package com.wantwant.test;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Mysql_springboot
 * @description: 订单编号生成类
 * @author: Sunhaoyue
 * @create: 2019/09/27 11:08
 */
public class OrderCodeGenerator {
    //自增长序列
    private int i=0;

    //安装"年月日时分秒-自动增长序列"规则排序订单编号
    public String  getOrderCode(){
        Date now=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
        return sdf.format(now)+ ++i;
    }

    public static void main(String[] args){
            OrderCodeGenerator ong=new OrderCodeGenerator();
            for(int i=0;i<10;i++){
                System.out.println(ong.getOrderCode());
            }
    }
}
