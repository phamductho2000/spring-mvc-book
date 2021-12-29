package com.webbansach.service.impl;

import com.webbansach.dto.CartDTO;
import com.webbansach.entity.*;
import com.webbansach.repository.*;
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

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void saveOrder(HashMap<Long, CartDTO> cart, long userId, String paymentCode, int totalPrice){
        UserEntity userEntity = userRepository.findOne(userId);
        PaymentEntity paymentEntity = paymentRepository.findByCode(paymentCode);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUser(userEntity);
        orderEntity.setTotal_price(totalPrice);
        orderEntity.setPayment(paymentEntity);
        orderEntity.setStatus(4);
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

    @Override
    public long saveOrderReturnId(HashMap<Long, CartDTO> cart, long userId, String paymentCode, int totalPrice){
        UserEntity userEntity = userRepository.findOne(userId);
        PaymentEntity paymentEntity = paymentRepository.findByCode(paymentCode);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUser(userEntity);
        orderEntity.setTotal_price(totalPrice);
        orderEntity.setPayment(paymentEntity);
        OrderEntity orderEntity1 = orderRepository.save(orderEntity);
        long idOrder = orderEntity1.getId();

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

        return idOrder;
    }

}
