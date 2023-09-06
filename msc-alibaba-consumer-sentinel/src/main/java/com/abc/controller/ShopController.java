package com.abc.controller;

import com.abc.bean.Product;
import com.abc.service.ConsumerShopService;
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

    //查询列表
    @GetMapping("/list")
    public List<Product> listHandle(){
        return shopService.listAllProducts().stream().peek (m->m.setName (m.getName ()+":"+port))
                .collect (Collectors.toList ());
    }
}
