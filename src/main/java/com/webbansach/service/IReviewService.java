package com.webbansach.service;

import com.webbansach.dto.ReviewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IReviewService {

    List<ReviewDTO> findAllByBookId(long id, Pageable pageable);

    void save(ReviewDTO reviewDTO);
}
