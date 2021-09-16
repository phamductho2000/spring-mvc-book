package com.webbansach.service.impl;

import com.webbansach.converter.CategoryConverter;
import com.webbansach.converter.WishlistConverter;
import com.webbansach.dto.WishlistDTO;
import com.webbansach.dto.ReviewDTO;
import com.webbansach.dto.WishlistDTO;
import com.webbansach.entity.BookEntity;
import com.webbansach.entity.CategoryEntity;
import com.webbansach.entity.WishlistEntity;
import com.webbansach.entity.UserEntity;
import com.webbansach.entity.WishlistEntity;
import com.webbansach.repository.BookRepository;
import com.webbansach.repository.CategoryRepository;
import com.webbansach.repository.UserRepository;
import com.webbansach.repository.WishlistRepository;
import com.webbansach.service.ICategoryService;
import com.webbansach.service.IWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService implements IWishlistService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WishlistConverter wishlistConverter;

    @Autowired
    WishlistRepository wishlistRepository;

    @Override
    public List<WishlistDTO> findAllByUserEntityId(long id, Pageable pageable){
        List<WishlistEntity> wishlistEntities = wishlistRepository.findAllByUserEntityId(id, pageable);
        List<WishlistDTO> wishlistDTOS = new ArrayList<>();
        for(WishlistEntity item: wishlistEntities){
            WishlistDTO wishlistDTO = wishlistConverter.entityToDTO(item);
            wishlistDTOS.add(wishlistDTO);
        }
        return wishlistDTOS;
    }

    @Override
    public void save(WishlistDTO wishlistDTO){
        WishlistEntity wishlistEntity = new WishlistEntity();
        BookEntity bookEntity = bookRepository.findOne(wishlistDTO.getBook().getId());
        UserEntity userEntity = userRepository.findOne(wishlistDTO.getUser().getId());
        wishlistEntity.setBookEntity(bookEntity);
        wishlistEntity.setUserEntity(userEntity);

        wishlistRepository.save(wishlistEntity);
    }

    @Override
    public void remove(long id){
        WishlistEntity wishlistEntity = wishlistRepository.findOne(id);
        wishlistRepository.delete(wishlistEntity);
    }
}
