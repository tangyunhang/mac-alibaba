package com.abc.service;

import com.abc.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "msc-alibaba-producer",fallbackFactory = ConsumerShopFallbackFactory.class)
// 参数为要调用的提供者相应的uri，抽取所有方法的公有uri地址
@RequestMapping("/provider/shop")
public interface ConsumerShopService {
    @PostMapping("/save")
    public boolean saveProduct(@RequestBody Product product);

    //查询列表
    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable("id") Integer id);

    //查询列表
    @GetMapping("/list")
    public List<Product> listAllProducts();
}
