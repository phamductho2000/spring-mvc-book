package com.webbansach.repository;

import com.webbansach.entity.BookEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findAllByCategoryId(long id, Pageable pageable);

    List<BookEntity> findByNameContaining(String key, Pageable pageable);

//    List<BookEntity> findAllByPublisherId(long id, Pageable pageable);
//
//    List<BookEntity> findAllByPublisherIdAndCategoryId(long pubId, long cateId, Pageable pageable);
//
//    List<BookEntity> findAllByPriceGreaterThanAndCategoryId(int money, long cateId, Pageable pageable);
//
//    List<BookEntity> findAllByPriceLessThanAndCategoryId(int money, long cateId, Pageable pageable);
//
//    Integer countAllByCategoryId(long id);

    @Transactional
    @Modifying
    @Query("delete from BookEntity b where b.id in ?1")
    void removeBooksByIds(List<Long> ids);

    @Query("select b, sum(d.quantity) from BookEntity b " +
            "inner join b.detailOrder d " +
            "group by b.id order by sum(d.quantity) desc")
    List<Object[]> findlAllFeature(Pageable pageable);

    @Query("select b, sum(d.quantity) from BookEntity b " +
            "inner join b.detailOrder d " +
            "where b.category.id = ?1 " +
            "group by b.id order by sum(d.quantity) desc")
    List<Object[]> findlAllFeatureByCateId(long cateId, Pageable pageable);

    @Query("select b from BookEntity b where ( ?1 = 'default' or (b.name like concat('%',?1,'%')) ) " +
            "and ( ?2 = -1 or (b.status = ?2) )" +
            "and ( ?3 = 0 or (b.category.id = ?3) )" +
            "and ( ?4 = 0 or (b.publisher.id = ?4) )")
    List<BookEntity> search(String key, int statusBook, int cateId, int pubId, Pageable pageable);

    @Query("select b from BookEntity b where b.category.id = ?1 and b.price >= ?2 and b.price <= ?3")
    List<BookEntity> searchByMoney(long cateId, int startMoney, int endMoney, Pageable pageable);
}
