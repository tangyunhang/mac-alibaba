package com.abc.controller;

import com.abc.bean.Product;
import com.abc.service.ConsumerShopFallback;
import com.abc.service.ConsumerShopService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: ShopController购物
 * @Author: 青衣醉
 * @Date: 2022/7/15 2:42 下午
 */
@RestController
@RequestMapping("/consumer/shop")
public class ShopController {

    @Value("${server.port}")
    String port;

    @Autowired
    ConsumerShopService shopService;


    @PostMapping("/save")
    public boolean saveProduct(@RequestBody Product product){
        return shopService.saveProduct (product);
    }


    //查询列表
    @DeleteMapping("/delete/{id}")
    public void deleteProductByName(@PathVariable("id") Integer id){
        shopService.deleteProductById(id);
    }

    //跨服务根据id查询(方法级别降级)
    // 该注解表明当前方法是一个由Sentinel管理的资源，value属性用于指定该资源的名称
    @SentinelResource(value = "getDepartById", fallback = "getHandlerFallback")
    @GetMapping("/get/{id}")
    public Product getHandle(@PathVariable("id") int id){
        return shopService.getProductById(id);
    }
    //指定服务降级处理方法
    public Product getHandlerFallback(int id) {
        Product depart = Product.builder().id(id).name("degrade-method-" +
                id).build();
        return depart;
    }

    //类级别的降级
    @SentinelResource(fallback = "listFallback"
            ,fallbackClass = ConsumerShopFallback.class)
    //查询列表
    @GetMapping("/list")
    public List<Product> listHandle(){
        return shopService.listAllProducts().stream().peek (m->m.setName (m.getName ()+":"+port))
                .collect (Collectors.toList ());
    }

}
