package com.webbansach.converter;

import com.webbansach.dto.BookDTO;
import com.webbansach.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public BookDTO entityToDTO(BookEntity bookEntity){
        BookDTO result = new BookDTO();
        result.setId(bookEntity.getId());
        result.setAuthor(bookEntity.getAuthor());
        result.setDescription(bookEntity.getDescription());
        result.setImage(bookEntity.getImage());
        result.setName(bookEntity.getName());
        result.setPage(bookEntity.getPage());
        result.setPrice(bookEntity.getPrice());
        result.setSize(bookEntity.getSize());
        result.setWeight(bookEntity.getWeight());
        result.setCategory_id(bookEntity.getCategory().getId());
        result.setPublisher_id(bookEntity.getPublisher().getId());
        result.setCreated_date(bookEntity.getCreated_date());
        result.setCreated_by(bookEntity.getCreated_by());
        result.setModified_by(bookEntity.getModified_by());
        return result;
    }

    public BookEntity dtoToEntity(BookDTO bookDTO){
        BookEntity result = new BookEntity();
        result.setAuthor(bookDTO.getAuthor());
        result.setDescription(bookDTO.getDescription());
        result.setImage(bookDTO.getImage());
        result.setName(bookDTO.getName());
        result.setPage(bookDTO.getPage());
        result.setPrice(bookDTO.getPrice());
        result.setSize(bookDTO.getSize());
        result.setWeight(bookDTO.getWeight());
        result.setCreated_date(bookDTO.getCreated_date());
        result.setCreated_by(bookDTO.getCreated_by());
        result.setModified_by(bookDTO.getModified_by());
        return result;
    }

    public BookEntity dtoToEntity(BookEntity result, BookDTO bookDTO){
        result.setAuthor(bookDTO.getAuthor());
        result.setDescription(bookDTO.getDescription());
        result.setImage(bookDTO.getImage());
        result.setName(bookDTO.getName());
        result.setPage(bookDTO.getPage());
        result.setPrice(bookDTO.getPrice());
        result.setSize(bookDTO.getSize());
        result.setWeight(bookDTO.getWeight());
        result.setCreated_date(bookDTO.getCreated_date());
        result.setCreated_by(bookDTO.getCreated_by());
        result.setModified_by(bookDTO.getModified_by());
        return result;
    }
}
