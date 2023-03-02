package com.abc.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Description: Product
 * @Author: 青衣醉
 * @Date: 2022/7/15 2:38 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private Long price;
    private Integer count;
}
