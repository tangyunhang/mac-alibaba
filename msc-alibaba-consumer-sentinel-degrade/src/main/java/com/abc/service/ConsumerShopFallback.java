package com.abc.service;

import com.abc.bean.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ShopServiceImplFallBack
 * @Author: 青衣醉
 * @Date: 2022/8/10 2:57 下午
 */
@Component
public class ConsumerShopFallback  {

    public static Product getFallback(int id,Throwable e){
        System.out.println("getHandle()执行异常 " + id);
        Product depart = Product.builder()
                .id(id)
                .name("degrade-class-" + id + "-" + e.getMessage())
                .build();
        return depart;
    }
    public static List<Product> listFallback(){
        System.out.println("listHandle()执行异常 ");
        List<Product> list = new ArrayList<>();
        list.add(Product.builder()
                .name("no any depart")
                .build());
        return list;
    }
}
