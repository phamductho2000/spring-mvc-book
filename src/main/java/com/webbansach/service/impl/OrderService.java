package com.webbansach.service.impl;

import com.webbansach.converter.DetailOrderConverter;
import com.webbansach.converter.OrderConverter;
import com.webbansach.dto.DetailOrderDTO;
import com.webbansach.dto.OrderDTO;
import com.webbansach.dto.PublisherDTO;
import com.webbansach.entity.DetailOrderEntity;
import com.webbansach.entity.OrderEntity;
import com.webbansach.entity.OrderEntity;
import com.webbansach.repository.DetailOrderRepository;
import com.webbansach.repository.OrderRepository;
import com.webbansach.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderConverter orderConverter;

    @Autowired
    DetailOrderRepository detailOrderRepository;

    @Autowired
    DetailOrderConverter detailOrderConverter;

    @Override
    public List<OrderDTO> findAll(Pageable pageable){
        Page<OrderEntity> orderEntities = orderRepository.findAll(pageable);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(OrderEntity item: orderEntities){
            OrderDTO orderDTO = orderConverter.entityToDTO(item);
            orderDTO.setUser_name(item.getUser().getName());
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public List<OrderDTO> findAllByUserId(long id, Pageable pageable){
        List<OrderEntity> orderEntities = orderRepository.findAllByUserId(id, pageable);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(OrderEntity item: orderEntities){
            OrderDTO orderDTO = orderConverter.entityToDTO(item);
            orderDTO.setUser_name(item.getUser().getName());
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public List<DetailOrderDTO> findAllDetailOrder(long orderId){
        List<DetailOrderEntity> detailOrderEntities = detailOrderRepository.findAllByOrderId(orderId);
        List<DetailOrderDTO> detailOrderDTOS = new ArrayList<>();
        for(DetailOrderEntity item: detailOrderEntities){
            DetailOrderDTO detailOrderDTO = detailOrderConverter.entityToDTO(item);
            detailOrderDTOS.add(detailOrderDTO);
        }
        return detailOrderDTOS;
    }

    @Override
    public List<OrderDTO> findAllByCurrentDay(Pageable pageable){
        List<OrderEntity> orderEntities = orderRepository.findAllByCurrentDay(pageable);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(OrderEntity item: orderEntities){
            OrderDTO orderDTO = orderConverter.entityToDTO(item);
            orderDTO.setUser_name(item.getUser().getName());
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public List<OrderDTO> findAllNewOrder(Pageable pageable){
        List<OrderEntity> orderEntities = orderRepository.findAllNewOrder(pageable);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(OrderEntity item: orderEntities){
            OrderDTO orderDTO = orderConverter.entityToDTO(item);
            orderDTO.setUser_name(item.getUser().getName());
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public OrderDTO findOne(long id){
        OrderEntity orderEntity = orderRepository.findOne(id);
        OrderDTO orderDTO = orderConverter.entityToDTO(orderEntity);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> findAllByPreviousDay(Pageable pageable){
        List<OrderEntity> orderEntities = orderRepository.findAllByPreviousDay(pageable);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(OrderEntity item: orderEntities){
            OrderDTO orderDTO = orderConverter.entityToDTO(item);
            orderDTO.setUser_name(item.getUser().getName());
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public List<OrderDTO> findAllByCurrentMonth(Pageable pageable){
        List<OrderEntity> orderEntities = orderRepository.findAllByCurrentMonth(pageable);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(OrderEntity item: orderEntities){
            OrderDTO orderDTO = orderConverter.entityToDTO(item);
            orderDTO.setUser_name(item.getUser().getName());
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public List<OrderDTO> findAllByPreviousMonth(Pageable pageable){
        List<OrderEntity> orderEntities = orderRepository.findAllByPreviousMonth(pageable);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(OrderEntity item: orderEntities){
            OrderDTO orderDTO = orderConverter.entityToDTO(item);
            orderDTO.setUser_name(item.getUser().getName());
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public List<OrderDTO> search(int id, int status, String startDate, String endDate, Pageable pageable){
        List<OrderEntity> orderEntities = orderRepository.search(id, status, startDate, endDate, pageable);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(OrderEntity item: orderEntities){
            OrderDTO orderDTO = orderConverter.entityToDTO(item);
            orderDTO.setUser_name(item.getUser().getName());
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public List<OrderDTO> findAllByStatus(int status, Pageable pageable){
        List<OrderEntity> orderEntities = orderRepository.findAllByStatus(status, pageable);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(OrderEntity item: orderEntities){
            OrderDTO orderDTO = orderConverter.entityToDTO(item);
            orderDTO.setUser_name(item.getUser().getName());
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public void save(OrderDTO orderDTO){
        OrderEntity orderEntity = new OrderEntity();

            OrderEntity orderEntityOld = orderRepository.findOne(orderDTO.getId());
            orderEntity = orderConverter.dtoToEntity(orderEntityOld, orderDTO);

        orderRepository.save(orderEntity);
    }

    @Override
    public int getTotalItem(){
        return (int) orderRepository.count();
    }

    @Override
    public int getTotalPriceAllOrder( ){ return orderRepository.totalPriceAllOrder();}

    @Override
    public int getTotalPriceOptionsOrder(List<OrderDTO> orderDTOS){
        int totalPrice = 0;
        for(OrderDTO orderDTO: orderDTOS){
            totalPrice+= orderDTO.getTotal_price();
        }
        return totalPrice;
    }
}
