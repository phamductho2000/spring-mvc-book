package com.webbansach.service.impl;

import com.webbansach.converter.ReviewConverter;
import com.webbansach.dto.CategoryDTO;
import com.webbansach.dto.ReviewDTO;
import com.webbansach.entity.BookEntity;
import com.webbansach.entity.CategoryEntity;
import com.webbansach.entity.ReviewEntity;
import com.webbansach.entity.UserEntity;
import com.webbansach.repository.BookRepository;
import com.webbansach.repository.ReviewRepository;
import com.webbansach.repository.UserRepository;
import com.webbansach.service.IBookService;
import com.webbansach.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService implements IReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewConverter reviewConverter;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<ReviewDTO> findAllByBookId(long id, Pageable pageable) {
        List<ReviewEntity> reviewEntities =  reviewRepository.findAllByBookId(id, pageable);
        List<ReviewDTO> reviewDTOS = new ArrayList<>();
        for(ReviewEntity item: reviewEntities) {
            ReviewDTO reviewDTO = reviewConverter.entityToDTO(item);
            reviewDTOS.add(reviewDTO);
        }
        return reviewDTOS;
    }

    @Override
    public void save(ReviewDTO reviewDTO){
        ReviewEntity reviewEntity = new ReviewEntity();
//        if(reviewDTO.getId() != null){
//            ReviewEntity reviewEntityOld = reviewRepository.findOne(reviewDTO.getId());
//            BookEntity bookEntity = bookRepository.findOne(reviewDTO.getBookId());
//            reviewEntity.setBookEntity(bookEntity);
//            reviewEntity = reviewConverter.dtoToEntity(reviewEntityOld, reviewDTO);
//        }
//        else{
            BookEntity bookEntity = bookRepository.findOne(reviewDTO.getBookId());
            UserEntity userEntity = userRepository.findOne(reviewDTO.getUserId());
            reviewEntity = reviewConverter.dtoToEntity(reviewDTO);
            reviewEntity.setBookEntity(bookEntity);
            reviewEntity.setUserEntity(userEntity);
//        }

        reviewRepository.save(reviewEntity);
    }
}
