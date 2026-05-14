package com.sopt.collaboration.domain.home.service;

import com.sopt.collaboration.domain.home.controller.CategoryResponse;
import com.sopt.collaboration.domain.home.controller.RecommendationResponse;
import com.sopt.collaboration.domain.home.entity.Category;
import com.sopt.collaboration.domain.home.entity.Product;
import com.sopt.collaboration.domain.home.entity.RecommendationProduct;
import com.sopt.collaboration.domain.home.entity.RecommendationSection;
import com.sopt.collaboration.domain.home.entity.User;
import com.sopt.collaboration.domain.home.exception.HomeErrorCode;
import com.sopt.collaboration.domain.home.exception.HomeException;
import com.sopt.collaboration.domain.home.repository.CategoryRepository;
import com.sopt.collaboration.domain.home.repository.RecommendationSectionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HomeService {

    private static final Long FIXED_USER_ID = 1L;
    private static final boolean FIXED_TOMORROW_DELIVERY = true;
    private static final String EXPAND_TRUE = "true";
    private static final String EXPAND_FALSE = "false";

    private final RecommendationSectionRepository recommendationSectionRepository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public RecommendationResponse getRecommendations() {
        RecommendationSection section = recommendationSectionRepository.findByUser_Id(FIXED_USER_ID)
                .orElseThrow(RuntimeException::new);

        User user = section.getUser();
        List<RecommendationResponse.Item> items = section.getRecommendationProducts().stream()
                .map(this::toItem)
                .toList();

        return new RecommendationResponse(
                user.getNickname() + "님의 최근 관심사와 비슷한 아이템",
                items
        );
    }

    @Transactional(readOnly = true)
    public CategoryResponse getCategories(String expand) {
        boolean isExpanded = parseExpand(expand);

        List<Category> categories = isExpanded
                ? categoryRepository.findAllByOrderByIdAsc()
                : categoryRepository.findTop10ByOrderByIdAsc();

        List<CategoryResponse.Category> items = categories.stream()
                .map(this::toCategory)
                .toList();

        return new CategoryResponse(items, items.size(), isExpanded);
    }

    private RecommendationResponse.Item toItem(RecommendationProduct recommendationProduct) {
        Product product = recommendationProduct.getProduct();
        return new RecommendationResponse.Item(
                product.getId(),
                product.getName(),
                product.getThumbnailImageUrl(),
                product.getOriginalPrice(),
                product.getDiscountRate(),
                product.getSalePrice(),
                FIXED_TOMORROW_DELIVERY
        );
    }

    private CategoryResponse.Category toCategory(Category category) {
        return new CategoryResponse.Category(
                category.getId(),
                category.getName(),
                category.getIconUrl()
        );
    }

    private boolean parseExpand(String expand) {
        if (expand == null || EXPAND_FALSE.equals(expand)) {
            return false;
        }
        if (EXPAND_TRUE.equals(expand)) {
            return true;
        }
        throw new HomeException(HomeErrorCode.INVALID_EXPAND_PARAMETER);
    }
}
