package com.abc.controller;

import com.abc.bean.Product;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: ShopController购物
 * @Author: 青衣醉
 * @Date: 2022/7/15 2:42 下午
 */
@RestController
@RequestMapping("/consumer/shop")
public class ShopNoFeginController {

    @Value("${server.port}")
    String port;

    @Autowired
    RestTemplate restTemplate;

    private static final String SERVICE_PROVIDER = "http://localhost:8071";
    @PostMapping("/save")
    public boolean saveProduct(@RequestBody Product product){
        String url = SERVICE_PROVIDER + "/provider/shop/save";
        return restTemplate.getForObject (url,Boolean.class);
    }


    //查询列表
    @DeleteMapping("/delete/{id}")
    public void deleteProductByName(@PathVariable("id") Integer id){

    }

    //查询列表
    @GetMapping("/list")
    public List<Product> listHandle(){
        String url = SERVICE_PROVIDER + "/provider/shop/list";
        List<HashMap>forObject = restTemplate.getForObject (url, List.class);
        List<Product> collect = forObject.stream ()
                .map (m -> JSON.parseObject (JSON.toJSONString (m),Product.class))
                .peek (m -> m.setName (m.getName () + ":" + port))
                .collect (Collectors.toList ());
        return collect;
    }
}
