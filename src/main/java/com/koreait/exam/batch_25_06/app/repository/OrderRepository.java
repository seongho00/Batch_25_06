package com.koreait.exam.batch_25_06.app.repository;


import com.koreait.exam.batch_25_06.app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
