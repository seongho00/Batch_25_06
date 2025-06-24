package com.koreait.exam.batch_25_06.app.service;


import com.koreait.exam.batch_25_06.app.entity.Product;
import com.koreait.exam.batch_25_06.app.entity.ProductOption;
import com.koreait.exam.batch_25_06.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product create(String name, int price, String makerShopName, List<ProductOption> options) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .makerShopName(makerShopName).build();

        for (ProductOption option : options) {
            product.addProductOption(option);
        }

        productRepository.save(product);

        return product;
    }
}