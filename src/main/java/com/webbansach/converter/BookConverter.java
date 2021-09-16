package com.webbansach.converter;

import com.webbansach.dto.BookDTO;
import com.webbansach.dto.ReviewDTO;
import com.webbansach.entity.BookEntity;
import com.webbansach.entity.ReviewEntity;
import com.webbansach.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookConverter {
    @Autowired
    IReviewService reviewService;

    public BookDTO entityToDTO(BookEntity bookEntity){
        int totalRate = 0;
        BookDTO result = new BookDTO();
        result.setId(bookEntity.getId());
        result.setAuthor(bookEntity.getAuthor());
        result.setShortDes(bookEntity.getShortDes());
        result.setDescription(bookEntity.getDescription());
        result.setImage(bookEntity.getImage());
        result.setName(bookEntity.getName());
        result.setPage(bookEntity.getPage());
        result.setPrice(bookEntity.getPrice());
        result.setOldPrice(bookEntity.getOldPrice());
        result.setQuanty(bookEntity.getQuanty());
        result.setDiscount(bookEntity.getDiscount());
        result.setSize(bookEntity.getSize());
        result.setWeight(bookEntity.getWeight());
        result.setStatus(bookEntity.getStatus());
        List<ReviewDTO> reviewDTOS = reviewService.findAllByBookId(bookEntity.getId(), null);
        if(reviewDTOS.size() != 0){
            for(ReviewDTO reviewDTO: reviewDTOS){
                totalRate += reviewDTO.getRate();
            }
            result.setRate(totalRate/(reviewDTOS.size()));
        }else{
            result.setRate(0);
        }
        result.setCountReviews(reviewDTOS.size());
        result.setCategory_id(bookEntity.getCategory().getId());
        result.setPublisher_id(bookEntity.getPublisher().getId());
        result.setNameCategory(bookEntity.getCategory().getName());
        result.setNamePublisher(bookEntity.getPublisher().getName());
        result.setCreated_date(bookEntity.getCreated_date());
        result.setUpdated_date(bookEntity.getUpdated_date());
        result.setCreated_by(bookEntity.getCreated_by());
        result.setModified_by(bookEntity.getModified_by());
        return result;
    }

    public BookEntity dtoToEntity(BookDTO bookDTO){
        BookEntity result = new BookEntity();
        result.setAuthor(bookDTO.getAuthor());
        result.setShortDes(bookDTO.getShortDes());
        result.setDescription(bookDTO.getDescription());
        result.setImage(bookDTO.getImage());
        result.setName(bookDTO.getName());
        result.setPage(bookDTO.getPage());
        result.setQuanty(bookDTO.getQuanty());
        result.setOldPrice(bookDTO.getOldPrice());
        if(bookDTO.getDiscount() == 0){
            result.setPrice(bookDTO.getOldPrice());
        }
        else{
            int price = (bookDTO.getOldPrice()/100)*(100 - bookDTO.getDiscount());
            result.setPrice(price);
        }
        result.setDiscount(bookDTO.getDiscount());
        result.setSize(bookDTO.getSize());
        result.setWeight(bookDTO.getWeight());
        result.setStatus(bookDTO.getStatus());
        result.setCreated_date(bookDTO.getCreated_date());
        result.setUpdated_date(bookDTO.getUpdated_date());
        result.setCreated_by(bookDTO.getCreated_by());
        result.setModified_by(bookDTO.getModified_by());
        return result;
    }

    public BookEntity dtoToEntity(BookEntity result, BookDTO bookDTO){
        result.setAuthor(bookDTO.getAuthor());
        result.setShortDes(bookDTO.getShortDes());
        result.setDescription(bookDTO.getDescription());
        if(bookDTO.getImage().equals("") == false){
            result.setImage(bookDTO.getImage());
        }
        result.setName(bookDTO.getName());
        result.setPage(bookDTO.getPage());
        result.setQuanty(bookDTO.getQuanty());
        result.setOldPrice(bookDTO.getOldPrice());
        if(bookDTO.getDiscount() == 0){
            result.setPrice(bookDTO.getOldPrice());
        }
        else{
            int price = (bookDTO.getOldPrice()/100)*(100 - bookDTO.getDiscount());
            result.setPrice(price);
        }
        result.setDiscount(bookDTO.getDiscount());
        result.setSize(bookDTO.getSize());
        result.setWeight(bookDTO.getWeight());
        result.setStatus(bookDTO.getStatus());
        result.setUpdated_date(bookDTO.getUpdated_date());
        result.setCreated_by(bookDTO.getCreated_by());
        result.setModified_by(bookDTO.getModified_by());
        return result;
    }
}
