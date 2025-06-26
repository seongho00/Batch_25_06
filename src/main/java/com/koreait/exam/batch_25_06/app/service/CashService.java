package com.koreait.exam.batch_25_06.app.service;

import com.koreait.exam.batch_25_06.app.entity.CartItem;
import com.koreait.exam.batch_25_06.app.entity.CashLog;
import com.koreait.exam.batch_25_06.app.entity.Member;
import com.koreait.exam.batch_25_06.app.entity.ProductOption;
import com.koreait.exam.batch_25_06.app.repository.CartItemRepository;
import com.koreait.exam.batch_25_06.app.repository.CashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CashService {

    private final CashRepository cashRepository;

    public CashLog addCash(Member member, long price, String eventType) {
        CashLog cashLog = CashLog.builder()
                .member(member)
                .price(price)
                .eventType(eventType).build();

        cashRepository.save(cashLog);

        return cashLog;
    }
}