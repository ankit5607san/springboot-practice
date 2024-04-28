package com.springpractice.reviews.services;

import com.springpractice.reviews.models.Review;

import java.util.List;

public interface ReviewService
{
    List<Review> getAll(Long companyId);

    boolean add(Long companyId, Review review);

    Review getReview(Long companyId, Long reviewId);

    boolean delete(Long companyId, Long reviewId);

    boolean update(Long companyId, Long reviewId, Review review);
}
