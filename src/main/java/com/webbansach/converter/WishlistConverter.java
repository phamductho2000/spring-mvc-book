package com.webbansach.converter;

import com.webbansach.dto.BookDTO;
import com.webbansach.dto.WishlistDTO;
import com.webbansach.dto.WishlistDTO;
import com.webbansach.entity.WishlistEntity;
import com.webbansach.entity.WishlistEntity;
import org.springframework.stereotype.Component;

@Component
public class WishlistConverter {
    public WishlistDTO entityToDTO(WishlistEntity wishlistEntity){
        WishlistDTO result = new WishlistDTO();
        BookDTO book = new BookDTO();
        if(wishlistEntity != null) {
            result.setId(wishlistEntity.getId());
            book.setId(wishlistEntity.getBookEntity().getId());
            book.setName(wishlistEntity.getBookEntity().getName());
            book.setAuthor(wishlistEntity.getBookEntity().getAuthor());
            book.setImage(wishlistEntity.getBookEntity().getImage());
            book.setOldPrice(wishlistEntity.getBookEntity().getOldPrice());
            book.setPrice(wishlistEntity.getBookEntity().getPrice());
            book.setShortDes(wishlistEntity.getBookEntity().getShortDes());
            book.setDescription(wishlistEntity.getBookEntity().getDescription());
            book.setDiscount(wishlistEntity.getBookEntity().getDiscount());
            book.setStatus(wishlistEntity.getBookEntity().getStatus());
        }
        result.setBook(book);
        return result;
    }

    public WishlistEntity dtoToEntity(WishlistDTO wishlistDTO) {
        WishlistEntity result = new WishlistEntity();

        return result;
    }

}
