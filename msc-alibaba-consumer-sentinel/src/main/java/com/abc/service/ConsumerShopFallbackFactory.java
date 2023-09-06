package com.abc.service;

import com.abc.bean.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: ShopServiceImplFallBack
 * @Author: 青衣醉
 * @Date: 2022/8/10 2:57 下午
 */
@Component
public class ConsumerShopFallbackFactory implements FallbackFactory<ConsumerShopService> {

    @Override
    public ConsumerShopService create(Throwable throwable) {
        return new ConsumerShopService () {
            @Override
            public boolean saveProduct(Product product) {
                return false;
            }

            @Override
            public void deleteProductById(Integer id) {
                System.out.println ("deleteProductById方法降级");
            }

            @Override
            public List<Product> listAllProducts() {
                System.out.println ("listAllProducts方法降级");
                return Arrays.asList (Product.builder ().id (3)
                        .count (20)
                        .name ("空")
                        .price (3L).build ())
                        ;
            }
        };
    }
}
