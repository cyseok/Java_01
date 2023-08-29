package com.moyeo.service;

import com.moyeo.dto.Review;

import java.util.Map;

public interface ReviewService {
    void addReview(Review review);
    void modifyReview(Review review);
    void removeReview(int userinfoId);

    Review getReviewByTitle(String reviewTitle);
    Review getReviewByContent(String reviewContent);
    Review getReview(int userinfoId);

    Map<String, Object> getReviewList(int pageNum);
}
