package com.webbansach.service.impl;

import com.webbansach.converter.BookConverter;
import com.webbansach.dto.BookDTO;
import com.webbansach.entity.BookEntity;
import com.webbansach.entity.CategoryEntity;
import com.webbansach.entity.PublisherEntity;
import com.webbansach.repository.BookRepository;
import com.webbansach.repository.CategoryRepository;
import com.webbansach.repository.PublisherRepository;
import com.webbansach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private BookConverter bookConverter;

    @Override
    public List<BookDTO> findAll() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(BookEntity item: bookEntities) {
            BookDTO bookDTO = bookConverter.entityToDTO(item);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public BookDTO findOne(long id) {
        BookEntity bookEntity = bookRepository.findOne(id);
        BookDTO bookDTO = bookConverter.entityToDTO(bookEntity);
        return bookDTO;
    }

    @Override
    public  List<BookDTO> findAllByCateId(long id, Pageable pageable){
        List<BookEntity> bookEntities = bookRepository.findAllByCategoryId(id, pageable);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(BookEntity item: bookEntities) {
            BookDTO bookDTO = bookConverter.entityToDTO(item);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public void save(BookDTO bookDTO){
        CategoryEntity category = categoryRepository.findOne(bookDTO.getCategory_id());
        PublisherEntity publisher = publisherRepository.findOne(bookDTO.getPublisher_id());
        BookEntity bookEntity = new BookEntity();
        if(bookDTO.getId() != null){
            BookEntity bookEntityOld = bookRepository.findOne(bookDTO.getId());
            bookEntityOld.setCategory(category);
            bookEntityOld.setPublisher(publisher);
            bookEntity = bookConverter.dtoToEntity(bookEntityOld, bookDTO);
        }
        else{
            bookEntity = bookConverter.dtoToEntity(bookDTO);
            bookEntity.setCategory(category);
            bookEntity.setPublisher(publisher);
        }

        bookRepository.save(bookEntity);
    }

    @Override
    public void remove(long id){
        BookEntity bookEntity = bookRepository.findOne(id);
        bookRepository.delete(bookEntity);
    }

    @Override
    public int getTotalItem(){
        return (int) bookRepository.count();
    }
}
