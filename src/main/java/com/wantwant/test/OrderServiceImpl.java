package com.wantwant.test;

/**
 * @program: Mysql_springboot
 * @description: 订单服务类
 * @author: Sunhaoyue
 * @create: 2019/09/27 11:20
 */
public class OrderServiceImpl implements OrderService{
   private OrderCodeGenerator ocg=new OrderCodeGenerator();

   //创建订单接口
   @Override
    public void createOrder() {
        String orderCode=ocg.getOrderCode();
       System.out.println(Thread.currentThread().getName()+"================>"+orderCode);
    }
}
