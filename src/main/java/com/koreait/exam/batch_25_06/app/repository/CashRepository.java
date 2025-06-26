package com.koreait.exam.batch_25_06.app.repository;


import com.koreait.exam.batch_25_06.app.entity.CashLog;
import com.koreait.exam.batch_25_06.app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashRepository extends JpaRepository<CashLog, Long> {
}