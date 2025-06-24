package com.koreait.exam.batch_25_06.app.repository;

import com.koreait.exam.batch_25_06.app.entity.CartItem;
import com.koreait.exam.batch_25_06.app.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByMemberIdAndProductOptionId(Long memberId, Long productOptionId);
}