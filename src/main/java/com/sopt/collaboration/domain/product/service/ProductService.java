package com.sopt.collaboration.domain.product.service;

import com.sopt.collaboration.domain.product.dto.response.CardBenefitResponse;
import com.sopt.collaboration.domain.product.dto.response.DeliveryResponse;
import com.sopt.collaboration.domain.product.dto.response.PointBenefitResponse;
import com.sopt.collaboration.domain.product.dto.response.ProductDetailResponse;
import com.sopt.collaboration.domain.product.entity.Product;
import com.sopt.collaboration.domain.product.exception.ProductNotFoundException;
import com.sopt.collaboration.domain.product.repository.CardBenefitRepository;
import com.sopt.collaboration.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;
    private final CardBenefitRepository cardBenefitRepository;

    public ProductDetailResponse getProductDetail(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);

        DeliveryResponse delivery = new DeliveryResponse(
                product.getFreeDelivery(),
                product.getArrivalDate().toString(),
                product.getDeadlineAt() == null ? null : product.getDeadlineAt().toString()
        );

        PointBenefitResponse pointBenefit = new PointBenefitResponse(
                product.getMaxPoint()
        );

        List<CardBenefitResponse> cardBenefits = cardBenefitRepository.findAllByProductId(productId)
                .stream()
                .map(cardBenefit -> new CardBenefitResponse(cardBenefit.getTitle()))
                .toList();

        return new ProductDetailResponse(
                product.getId(),
                product.getBrandName(),
                product.getThumbnailImageUrl(),
                product.getName(),
                product.getReviewScore(),
                product.getRecentReviewScore(),
                product.getReviewCount(),
                product.getDiscountRate(),
                product.getOriginalPrice(),
                product.getSalePrice(),
                product.getMemberPrice(),
                product.getCouponAvailable(),
                product.getCouponDday(),
                product.getUnitPrice(),
                product.getUnitQuantity(),
                product.getUnit(),
                delivery,
                pointBenefit,
                cardBenefits
        );
    }
}