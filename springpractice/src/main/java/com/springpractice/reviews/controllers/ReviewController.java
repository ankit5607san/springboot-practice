package com.springpractice.reviews.controllers;

import com.springpractice.reviews.models.Review;
import com.springpractice.reviews.services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController
{
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService)
    {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAll(@PathVariable Long companyId)
    {
        return ResponseEntity.ok(reviewService.getAll(companyId));
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@PathVariable Long companyId, @RequestBody Review review)
    {
        if (reviewService.add(companyId, review))
        {
            return ResponseEntity.ok("review added for company [" + companyId + "] successfully");
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId)
    {
        return ResponseEntity.ok(reviewService.getReview(companyId, reviewId));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> delete(@PathVariable Long companyId, @PathVariable Long reviewId)
    {
        if (reviewService.delete(companyId, reviewId))
        {
            return ResponseEntity.ok("deleted review [" + reviewId + "] for company [" + companyId + "] successfully");
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> update(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review)
    {
        if (reviewService.update(companyId, reviewId, review))
        {
            return ResponseEntity.ok("updated review [" + reviewId + "] for company [" + companyId + "] ");
        }

        return ResponseEntity.badRequest().build();
    }
}
