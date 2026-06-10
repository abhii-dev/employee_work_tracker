package com.track.service;

import java.util.List;

import com.track.dto.ReviewRequestDto;
import com.track.dto.ReviewResponseDto;

public interface ReviewService {

    ReviewResponseDto createReview(
            ReviewRequestDto requestDto);

    ReviewResponseDto getReviewById(Long id);

    List<ReviewResponseDto> getAllReviews();

    List<ReviewResponseDto> getReviewsByEmployee(
            Long employeeId);

    void deleteReview(Long id);
}