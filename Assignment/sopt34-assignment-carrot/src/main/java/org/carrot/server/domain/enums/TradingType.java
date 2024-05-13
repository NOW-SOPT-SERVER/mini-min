package org.carrot.server.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TradingType {

    SALE("판매하기"),
    SHARE("나눔하기"),
    ;

    public final String type;
}
