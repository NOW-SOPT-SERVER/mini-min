package org.carrot.server.domain;

import jakarta.persistence.*;
import lombok.*;
import org.carrot.server.domain.enums.SaleStatus;
import org.carrot.server.domain.enums.TradingType;
import org.carrot.server.service.dto.request.ProductCreateRequest;

@Entity
@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(length = 200)
    private String title;

    @Enumerated(EnumType.STRING)
    private TradingType tradingType;
    private Integer price;
    private Boolean isSuggestedPrice;
    private String description;

    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus;

    public static Product create(
            User user,
            ProductCreateRequest productCreateRequest
    ) {
        return Product.builder()
                .user(user)
                .title(productCreateRequest.title())
                .tradingType(productCreateRequest.tradingType())
                .price(productCreateRequest.price())
                .isSuggestedPrice(productCreateRequest.isSuggestedPrice())
                .description(productCreateRequest.description())
                .saleStatus(productCreateRequest.saleStatus())
                .build();
    }
}
