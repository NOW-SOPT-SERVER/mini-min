package org.carrot.server.service.dto.request;

import org.carrot.server.domain.enums.SaleStatus;
import org.carrot.server.domain.enums.TradingType;

public record ProductCreateRequest(
        String title,
        TradingType tradingType,
        Integer price,
        Boolean isSuggestedPrice,
        String description,
        SaleStatus saleStatus
) {
}
