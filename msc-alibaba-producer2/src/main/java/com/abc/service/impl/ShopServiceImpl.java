package com.abc.service.impl;

import com.abc.bean.Product;
import com.abc.repository.ShopRepository;
import com.abc.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description: ShopServiceImpl
 * @Author: 青衣醉
 * @Date: 2022/7/15 3:27 下午
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Value("${server.port}")
    String port;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ApplicationContext applicationContext;
    @Override
    public boolean saveProduct(Product product) {
        return Optional.ofNullable (shopRepository.save (product))
                .isPresent ();
    }

    @Override
    public void deleteProductById(Integer id) {
        if (shopRepository.existsById (id)) {
            shopRepository.deleteById (id);
        }
    }

    @Override
    public List<Product> listAllProducts() {
       return shopRepository.findAll ()
                .stream().peek (m->m.setName (m.getName ()+":"+port))
                .collect (Collectors.toList ());
    }

}
