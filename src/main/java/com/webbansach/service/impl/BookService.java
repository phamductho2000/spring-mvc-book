package com.webbansach.service.impl;

import com.webbansach.converter.BookConverter;
import com.webbansach.dto.BookDTO;
import com.webbansach.entity.BookEntity;
import com.webbansach.entity.CategoryEntity;
import com.webbansach.entity.PublisherEntity;
import com.webbansach.repository.BookRepository;
import com.webbansach.repository.CategoryRepository;
import com.webbansach.repository.CustomBookRepository;
import com.webbansach.repository.PublisherRepository;
import com.webbansach.service.IBookService;
import static com.webbansach.specifications.BookSpecification.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.springframework.data.jpa.domain.Specifications.where;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomBookRepository customBookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookConverter bookConverter;

    @Override
    public List<BookDTO> findAll(Pageable pageable) {
        Page<BookEntity> bookEntities =  bookRepository.findAll(pageable);
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
    public List<BookDTO> findByKey(String key, Pageable pageable) {
        List<BookEntity> bookEntities = bookRepository.findByNameContaining(key, pageable);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(BookEntity item: bookEntities) {
            BookDTO bookDTO = bookConverter.entityToDTO(item);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public List<BookDTO> search(int cateId, int publisherId, int min, int max, Pageable pageable){

        Page<BookEntity> bookEntities = customBookRepository.findAll(filter(cateId, publisherId, min, max), pageable);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(BookEntity item: bookEntities) {
            BookDTO bookDTO = bookConverter.entityToDTO(item);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

//    @Override
//    public List<BookDTO> search(String name, int status, int cateId, int publisherId, Pageable pageable){
//
//        Page<BookEntity> bookEntities = customBookRepository.findAll(search(name, status, cateId, publisherId), pageable);
//        List<BookDTO> bookDTOS = new ArrayList<>();
//        for(BookEntity item: bookEntities) {
//            BookDTO bookDTO = bookConverter.entityToDTO(item);
//            bookDTOS.add(bookDTO);
//        }
//        return bookDTOS;
//    }

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

//    @Override
//    public  List<BookDTO> findAllByPublId(long id, Pageable pageable){
//        List<BookEntity> bookEntities = bookRepository.findAllByPublisherId(id, pageable);
//        List<BookDTO> bookDTOS = new ArrayList<>();
//        for(BookEntity item: bookEntities) {
//            BookDTO bookDTO = bookConverter.entityToDTO(item);
//            bookDTOS.add(bookDTO);
//        }
//        return bookDTOS;
//    }

//    @Override
//    public  List<BookDTO> findAllByPublIdandCateId(long pubId, long cateId,  Pageable pageable){
//        List<BookEntity> bookEntities = bookRepository.findAllByPublisherIdAndCategoryId(pubId, cateId, pageable);
//        List<BookDTO> bookDTOS = new ArrayList<>();
//        for(BookEntity item: bookEntities) {
//            BookDTO bookDTO = bookConverter.entityToDTO(item);
//            bookDTOS.add(bookDTO);
//        }
//        return bookDTOS;
//    }

    @Override
    public  List<BookDTO> findAllNew(Pageable pageable){
        Page<BookEntity> bookEntities =  bookRepository.findAll(pageable);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(BookEntity item: bookEntities) {
            BookDTO bookDTO = bookConverter.entityToDTO(item);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public  List<BookDTO> findAllFeature(Pageable pageable){
        List<BookEntity> bookEntities =  new ArrayList<>();
        for (Object result[]: bookRepository.findlAllFeature(pageable)){
            bookEntities.add((BookEntity) result[0]);
        }
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(BookEntity item: bookEntities) {
            BookDTO bookDTO = bookConverter.entityToDTO(item);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

//    @Override
//    public  List<BookDTO> findAllFeatureByCateId(long cateId, Pageable pageable){
//        List<BookEntity> bookEntities =  new ArrayList<>();
//        for (Object result[]: bookRepository.findlAllFeatureByCateId(cateId, pageable)){
//            bookEntities.add((BookEntity) result[0]);
//        }
//        List<BookDTO> bookDTOS = new ArrayList<>();
//        for(BookEntity item: bookEntities) {
//            BookDTO bookDTO = bookConverter.entityToDTO(item);
//            bookDTOS.add(bookDTO);
//        }
//        return bookDTOS;
//    }

    @Override
    public  List<BookDTO> searchBook(String key, int statusBook, int cate, int publ, Pageable pageable){
        List<BookEntity> bookEntities = bookRepository.search(key, statusBook, cate, publ, pageable);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(BookEntity item: bookEntities) {
            BookDTO bookDTO = bookConverter.entityToDTO(item);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

//    @Override
//    public  List<BookDTO> searchByMoney(long cateId, int startMoney, int endMoney, Pageable pageable){
//        List<BookEntity> bookEntities = new ArrayList<>();
//        if(startMoney > 0 && endMoney == 0){
//            bookEntities = bookRepository.findAllByPriceGreaterThanAndCategoryId(startMoney, cateId, pageable);
//        }
//        if(startMoney == 0 && endMoney > 0){
//            bookEntities = bookRepository.findAllByPriceLessThanAndCategoryId(endMoney, cateId, pageable);
//        }
//        if(startMoney > 0 && endMoney > 0){
//            bookEntities = bookRepository.searchByMoney(cateId, startMoney, endMoney, pageable);
//        }
//        List<BookDTO> bookDTOS = new ArrayList<>();
//        for(BookEntity item: bookEntities) {
//            BookDTO bookDTO = bookConverter.entityToDTO(item);
//            bookDTOS.add(bookDTO);
//        }
//        return bookDTOS;
//    }

    @Override
    public void save(BookDTO bookDTO){
        CategoryEntity category = categoryRepository.findOne(bookDTO.getCategory_id());
        PublisherEntity publisher = publisherRepository.findOne(bookDTO.getPublisher_id());
        BookEntity bookEntity = new BookEntity();
        if(bookDTO.getId() != 0){
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
    public void remove(Long[] ids){
        bookRepository.removeBooksByIds(Arrays.asList((ids)));
    }

    @Override
    public int getTotalItem(){
        return (int) bookRepository.count();
    }

//    @Override
//    public int getTotalItemByCateId(long cateId){
//        return bookRepository.countAllByCategoryId(cateId);
//    }

}
