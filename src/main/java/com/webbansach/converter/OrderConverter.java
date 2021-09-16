package com.webbansach.converter;

import com.webbansach.dto.OrderDTO;
import com.webbansach.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
    public OrderDTO entityToDTO(OrderEntity orderEntity){
        OrderDTO result = new OrderDTO();
        result.setId(orderEntity.getId());
        result.setTotal_price(orderEntity.getTotal_price());
        result.setUser_id(orderEntity.getUser().getId());
        result.setUser_name(orderEntity.getUser().getName());
        result.setUser_address(orderEntity.getUser().getAddress());
        result.setUser_phone(orderEntity.getUser().getPhone());
        result.setStatus(orderEntity.getStatus());
        result.setCreated_date(orderEntity.getCreated_date());
        result.setCreated_by(orderEntity.getCreated_by());
        result.setModified_by(orderEntity.getModified_by());
        return result;
    }

    public OrderEntity dtoToEntity(OrderDTO orderDTO){
        OrderEntity result = new OrderEntity();
        result.setTotal_price(orderDTO.getTotal_price());
        result.setStatus(orderDTO.getStatus());
        result.setCreated_date(orderDTO.getCreated_date());
        result.setCreated_by(orderDTO.getCreated_by());
        result.setModified_by(orderDTO.getModified_by());
        return result;
    }

    public OrderEntity dtoToEntity(OrderEntity result, OrderDTO orderDTO){
        result.setTotal_price(orderDTO.getTotal_price());
        result.setStatus(orderDTO.getStatus());
        result.setCreated_date(orderDTO.getCreated_date());
        result.setCreated_by(orderDTO.getCreated_by());
        result.setModified_by(orderDTO.getModified_by());
        return result;
    }
}
