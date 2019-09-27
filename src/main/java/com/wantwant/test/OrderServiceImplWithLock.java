package com.wantwant.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Mysql_springboot
 * @description: 带锁的多线程并发
 * @author: Sunhaoyue
 * @create: 2019/09/27 11:39
 */
public class OrderServiceImplWithLock implements OrderService {
    //订单编号生产器  static修饰 多个Tomcat是用一个订单编号生成 static是类拥有的，不是对象用用的
    private static OrderCodeGenerator ocg=new OrderCodeGenerator();
    //同一个锁在分布式集群里， 加锁  static修饰 多个Tomcat是用一个订单编号生成 static是类拥有的，不是对象用用的
    private static Lock lock=new ReentrantLock();

    //创建订单接口
    @Override
    public void createOrder() {
        String orderCode=null;
        try{
            lock.lock();
            //订单获取
            orderCode =ocg.getOrderCode();
        }finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName()+"=======创建了锁=======>"+orderCode);
    }
}
