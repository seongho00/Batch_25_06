package com.koreait.exam.batch_25_06.app.repository;


import com.koreait.exam.batch_25_06.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
