package com.track.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.track.dto.ReviewRequestDto;
import com.track.dto.ReviewResponseDto;
import com.track.entity.Employee;
import com.track.entity.Manager;
import com.track.entity.Review;
import com.track.repository.EmployeeRepository;
import com.track.repository.ManagerRepository;
import com.track.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;

    public ReviewServiceImpl(
            ReviewRepository reviewRepository,
            EmployeeRepository employeeRepository,
            ManagerRepository managerRepository) {

        this.reviewRepository = reviewRepository;
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
    }

    @Override
    public ReviewResponseDto createReview(
            ReviewRequestDto requestDto) {

        if (requestDto.getRating() < 1 ||
                requestDto.getRating() > 5) {

            throw new RuntimeException(
                    "Rating must be between 1 and 5");
        }

        if (requestDto.getComments() == null ||
                requestDto.getComments().trim().isEmpty()) {

            throw new RuntimeException(
                    "Comments cannot be empty");
        }

        Employee employee = employeeRepository
                .findById(requestDto.getEmployeeId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Employee not found"));

        Manager manager = managerRepository
                .findById(requestDto.getManagerId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Manager not found"));

        Review review = new Review();

        review.setRating(requestDto.getRating());
        review.setComments(requestDto.getComments());
        review.setReviewDate(LocalDate.now());
        review.setEmployee(employee);
        review.setManager(manager);

        Review savedReview =
                reviewRepository.save(review);

        return mapToDto(savedReview);
    }

    @Override
    public ReviewResponseDto getReviewById(Long id) {

        Review review = reviewRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Review not found"));

        return mapToDto(review);
    }

    @Override
    public List<ReviewResponseDto> getAllReviews() {

        return reviewRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewResponseDto> getReviewsByEmployee(
            Long employeeId) {

        return reviewRepository
                .findByEmployeeId(employeeId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteReview(Long id) {

        Review review = reviewRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Review not found"));

        reviewRepository.delete(review);
    }

    private ReviewResponseDto mapToDto(
            Review review) {

        ReviewResponseDto dto =
                new ReviewResponseDto();

        dto.setId(review.getId());
        dto.setRating(review.getRating());
        dto.setComments(review.getComments());
        dto.setReviewDate(review.getReviewDate());

        dto.setEmployeeId(
                review.getEmployee().getId());

        dto.setEmployeeName(
                review.getEmployee().getFirstName()
                        + " "
                        + review.getEmployee().getLastName());

        dto.setManagerId(
                review.getManager().getId());

        dto.setManagerName(
                review.getManager().getFirstName()
                        + " "
                        + review.getManager().getLastName());

        return dto;
    }
}