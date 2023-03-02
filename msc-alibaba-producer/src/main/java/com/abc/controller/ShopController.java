package com.abc.controller;

import com.abc.bean.Product;
import com.abc.service.ShopService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: ShopController购物
 * @Author: 青衣醉
 * @Date: 2022/7/15 2:42 下午
 */
@RestController
@RequestMapping("/provider/shop")
@RefreshScope
public class ShopController {

    @Autowired
    ShopService shopService;

    @Value ("${depart.memo}")
    private String memo;
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

        return shopService.listAllProducts().stream ()
                .peek (n->n.setName (n.getName ()+memo))
                .collect (Collectors.toList ());
    }
}
