package com.wantwant.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: Mysql_springboot
 * @description: 订单编号控制类
 * @author: Sunhaoyue
 * @create: 2019/09/27 11:06
 */
public class OrderCodeController {

    public static void main(String[] args){
        //并发数
        int currency=20;
        //循环屏障
        CyclicBarrier cb=new CyclicBarrier(currency);
        //订单创建
        //OrderService orderService=new OrderServiceImplWithLock();
        //多线程并发
        for(int i=0;i<currency;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //模拟分布式集群场景
                    OrderService orderService=new OrderServiceImplWithLock();
                    System.out.println(Thread.currentThread()+"------------我准备好了----------");
                    try{
                        cb.await();
                    }catch(InterruptedException| BrokenBarrierException e){
                        e.printStackTrace();
                    }
                    //调用创建服务
                    orderService.createOrder();
                }
            }).start();
        }
    }
}
