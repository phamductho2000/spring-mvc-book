package com.webbansach.service.impl;

import com.webbansach.dto.CartDTO;
import com.webbansach.entity.BookEntity;
import com.webbansach.entity.DetailOrderEntity;
import com.webbansach.entity.OrderEntity;
import com.webbansach.entity.UserEntity;
import com.webbansach.repository.BookRepository;
import com.webbansach.repository.DetailOrderRepository;
import com.webbansach.repository.OrderRepository;
import com.webbansach.repository.UserRepository;
import com.webbansach.service.ICheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Set;

@Service
public class CheckoutService implements ICheckoutService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    DetailOrderRepository detailOrderRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveOrder(HashMap<Long, CartDTO> cart, long userId, int totalPrice){
        UserEntity userEntity = userRepository.findOne(userId);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUser(userEntity);
        orderEntity.setTotal_price(totalPrice);
        orderRepository.save(orderEntity);

        Set<Long> keySet = cart.keySet();
        for (Long key : keySet) {
            DetailOrderEntity detailOrderEntity = new DetailOrderEntity();
            BookEntity bookEntity = bookRepository.findOne(key);
            detailOrderEntity.setBookEntity(bookEntity);
            detailOrderEntity.setPrice(bookEntity.getPrice());
            detailOrderEntity.setQuantity(cart.get(key).getQuanty());
            detailOrderEntity.setTotal(cart.get(key).getTotalPrice());
            detailOrderEntity.setOrder(orderEntity);
            detailOrderRepository.save(detailOrderEntity);
            bookEntity.setQuanty(bookEntity.getQuanty() - cart.get(key).getQuanty());
            bookRepository.save(bookEntity);
        }

    }

}
