package com.springpractice.reviews.repositories;

import com.springpractice.reviews.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>
{
    List<Review> findByCompanyId(Long companyId);

    Review findByCompanyIdAndId(Long companyId, Long reviewId);

    boolean existsByIdAndCompanyId(Long reviewId, Long companyId);

    boolean deleteByIdAndCompanyId(Long reviewId, Long companyId);
}
