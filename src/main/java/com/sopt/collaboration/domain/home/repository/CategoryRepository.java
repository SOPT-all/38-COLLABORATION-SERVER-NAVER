package com.sopt.collaboration.domain.home.repository;

import com.sopt.collaboration.domain.home.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findTop10ByOrderByIdAsc();

    List<Category> findAllByOrderByIdAsc();
}
