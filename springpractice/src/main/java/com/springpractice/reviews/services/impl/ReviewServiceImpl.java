package com.springpractice.reviews.services.impl;

import com.springpractice.companies.models.Company;
import com.springpractice.companies.repositories.CompanyRepository;
import com.springpractice.reviews.models.Review;
import com.springpractice.reviews.repositories.ReviewRepository;
import com.springpractice.reviews.services.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService
{
    private final ReviewRepository reviewRepository;

    private final CompanyRepository companyRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyRepository companyRepository)
    {
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Review> getAll(Long companyId)
    {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean add(Long companyId, Review review)
    {
        Optional<Company> company = companyRepository.findById(companyId);

        if (company.isPresent())
        {
            review.setCompany(company.get());

            reviewRepository.save(review);

            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId)
    {
        return reviewRepository.findByCompanyIdAndId(companyId, reviewId);
    }

    @Override
    public boolean delete(Long companyId, Long reviewId)
    {
        if (reviewRepository.existsByIdAndCompanyId(reviewId, companyId))
        {
            Review review = reviewRepository.findByCompanyIdAndId(companyId, reviewId);

            Optional<Company> company = companyRepository.findById(review.getCompany().getId());

            company.ifPresent(value ->
            {

                value.getReviews().remove(review);

                companyRepository.save(value);
            });

            review.setCompany(null);

            reviewRepository.delete(review);

            return true;
        }

        return false;
    }

    @Override
    public boolean update(Long companyId, Long reviewId, Review review)
    {
        if (reviewRepository.existsByIdAndCompanyId(reviewId, companyId))
        {
            Review dbReview = reviewRepository.findByCompanyIdAndId(companyId, reviewId);

            if (dbReview != null)
            {
                dbReview.setTitle(review.getTitle());

                dbReview.setDescription(review.getDescription());

                dbReview.setRating(review.getRating());

                reviewRepository.save(dbReview);

                return true;
            }
        }

        return false;
    }
}
