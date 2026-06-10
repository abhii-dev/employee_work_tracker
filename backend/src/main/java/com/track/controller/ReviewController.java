package com.track.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.track.dto.ReviewRequestDto;
import com.track.dto.ReviewResponseDto;
import com.track.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewResponseDto> createReview(
            @RequestBody ReviewRequestDto requestDto) {

        return ResponseEntity.ok(
                reviewService.createReview(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> getReviewById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                reviewService.getReviewById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponseDto>> getAllReviews() {

        return ResponseEntity.ok(
                reviewService.getAllReviews());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<ReviewResponseDto>>
    getReviewsByEmployee(
            @PathVariable Long employeeId) {

        return ResponseEntity.ok(
                reviewService.getReviewsByEmployee(employeeId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(
            @PathVariable Long id) {

        reviewService.deleteReview(id);

        return ResponseEntity.ok(
                "Review deleted successfully");
    }
}