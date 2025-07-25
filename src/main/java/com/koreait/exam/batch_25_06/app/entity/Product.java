package com.koreait.exam.batch_25_06.app.entity;


import com.koreait.exam.batch_25_06.app.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Product extends BaseEntity {
    private String name;
    private int salePrice;
    private int price;
    private int wholeSalePrice;
    private String makerShopName;

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = ALL, orphanRemoval = true)
    private List<ProductOption> productOptions = new ArrayList<>();

    public void addProductOption(ProductOption option) {
        option.setProduct(this);
        option.setPrice(getPrice());
        option.setWholeSalePrice(getWholeSalePrice());
        option.setSalePrice(getSalePrice());

        productOptions.add(option);
    }
}