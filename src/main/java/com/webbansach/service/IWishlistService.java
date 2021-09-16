package com.webbansach.service;

import com.webbansach.dto.WishlistDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IWishlistService {

    List<WishlistDTO> findAllByUserEntityId(long id, Pageable pageable);

    void save(WishlistDTO wishlistDTO);

    void remove(long id);
}
