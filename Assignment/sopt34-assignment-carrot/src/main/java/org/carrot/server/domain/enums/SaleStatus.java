package org.carrot.server.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SaleStatus {

    AVAILABLE("거래가능"),
    RESERVED("예약중"),
    SOLD_OUT("거래완료"),
    GIVEN("나눔완료"),
    ;

    private final String status;
}
