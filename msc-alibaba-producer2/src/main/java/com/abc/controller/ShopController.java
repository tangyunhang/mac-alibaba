package com.abc.controller;

import com.abc.bean.Product;
import com.abc.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: ShopController购物
 * @Author: 青衣醉
 * @Date: 2022/7/15 2:42 下午
 */
@RestController
@RequestMapping("/provider/shop")
public class ShopController {

    public String port;
    @Autowired
    ShopService shopService;

    @Autowired
    DiscoveryClient discoveryClient;


    @PostMapping("/save")
    public boolean saveProduct(@RequestBody Product product){
        return shopService.saveProduct (product);
    }

    @GetMapping("/get")
    public void getShop(){

        List<Product> products = shopService.listAllProducts();
    }

    //查询列表
    @DeleteMapping("/delete/{id}")
    public void deleteProductByName(@PathVariable("id") Integer id){
        shopService.deleteProductById(id);
    }

    //查询列表
    @GetMapping("/list")
    public List<Product> listHandle(){

        return shopService.listAllProducts();
    }
    @GetMapping("/discovery")
    public List<String> discoveryHandler(){
        List<String> services = discoveryClient.getServices();
        services.forEach(name->{
            //获取当前遍历微服务名称的所有提供者
            List<ServiceInstance> instances = discoveryClient.getInstances(name);
            instances.forEach(instance->{
                //当前提供者唯一标识
                String instanceId = instance.getInstanceId();
                String serviceId = instance.getServiceId();
                String host = instance.getHost();
                System.out.println("serviceId="+serviceId);
                System.out.println("instanceId="+instanceId);
                System.out.println("host="+host);
            });
        });
        return services;
    }
}
