package com.webbansach.service;

import com.webbansach.dto.BookDTO;
import com.webbansach.entity.BookEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import java.util.List;

public interface IBookService {

    List<BookDTO> findAll(Pageable pageable);

    BookDTO findOne(long id);

    List<BookDTO> findByKey(String key, Pageable pageable);

    List<BookDTO> findAllByCateId(long id, Pageable pageable);

//    List<BookDTO> findAllByPublId(long id, Pageable pageable);
//
//    List<BookDTO> findAllByPublIdandCateId(long pubId, long cateId, Pageable pageable);

    List<BookDTO> findAllNew(Pageable pageable);

    List<BookDTO> findAllFeature(Pageable pageable);

//    List<BookDTO> findAllFeatureByCateId(long cateId, Pageable pageable);

    List<BookDTO> searchBook(String key, int statusBook, int cate, int publ, Pageable pageable);

//    List<BookDTO> searchByMoney(long cateId, int startMoney, int endMoney, Pageable pageable);

    void save(BookDTO bookDTO);

    void remove(long id);

    void remove(Long[] ids);

    int getTotalItem();

//    int getTotalItemByCateId(long cateId);

    List<BookDTO> search(int cateId, int publisherId, int min, int max, Pageable pageable);
}
