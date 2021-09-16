package com.webbansach.converter;

import com.webbansach.dto.ReviewDTO;
import com.webbansach.entity.ReviewEntity;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {
    public ReviewDTO entityToDTO(ReviewEntity reviewEntity){
        ReviewDTO result = new ReviewDTO();
        result.setBookId(reviewEntity.getBookEntity().getId());
        result.setUserId(reviewEntity.getUserEntity().getId());
        result.setRate(reviewEntity.getRate());
        result.setUserName(reviewEntity.getUserEntity().getName());
        result.setContent(reviewEntity.getContent());
        result.setCreated_date(reviewEntity.getCreated_date());
        result.setUpdated_date(reviewEntity.getUpdated_date());
        return result;
    }

    public ReviewEntity dtoToEntity(ReviewDTO reviewDTO) {
        ReviewEntity result = new ReviewEntity();
        result.setRate(reviewDTO.getRate());
        result.setContent(reviewDTO.getContent());
        result.setCreated_date(reviewDTO.getCreated_date());
        result.setUpdated_date(reviewDTO.getUpdated_date());
        return result;
    }

    public ReviewEntity dtoToEntity(ReviewEntity result, ReviewDTO reviewDTO){
        result.setRate(reviewDTO.getRate());
        result.setContent(reviewDTO.getContent());
        result.setCreated_date(reviewDTO.getCreated_date());
        result.setUpdated_date(reviewDTO.getUpdated_date());
        return result;
    }
}
