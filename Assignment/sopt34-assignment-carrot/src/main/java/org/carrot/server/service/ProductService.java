package org.carrot.server.service;

import lombok.RequiredArgsConstructor;
import org.carrot.server.domain.Product;
import org.carrot.server.domain.User;
import org.carrot.server.repository.ProductRepository;
import org.carrot.server.service.dto.request.ProductCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;

    @Transactional
    public void createProduct(
            final Long userId,
            final ProductCreateRequest productCreateRequest
    ) {
        User user = userService.findById(userId);
        Product product = Product.create(user, productCreateRequest);
        productRepository.save(product);
    }
}
