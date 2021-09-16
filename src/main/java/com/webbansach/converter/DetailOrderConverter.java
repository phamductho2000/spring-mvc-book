package com.webbansach.converter;

import com.webbansach.dto.DetailOrderDTO;
import com.webbansach.dto.OrderDTO;
import com.webbansach.entity.DetailOrderEntity;
import com.webbansach.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class DetailOrderConverter {
    public DetailOrderDTO entityToDTO(DetailOrderEntity detailOrderEntity){
        DetailOrderDTO result = new DetailOrderDTO();
        result.setId(detailOrderEntity.getId());
        result.setOrder_id(detailOrderEntity.getOrder().getId());
        result.setBook_id(detailOrderEntity.getBookEntity().getId());
        result.setBookName(detailOrderEntity.getBookEntity().getName());
        result.setImgBook(detailOrderEntity.getBookEntity().getImage());
        result.setDiscount(detailOrderEntity.getDiscount());
        result.setQuantity(detailOrderEntity.getQuantity());
        result.setPrice(detailOrderEntity.getPrice());
        result.setTotal(detailOrderEntity.getTotal());
        result.setCreated_date(detailOrderEntity.getCreated_date());
        result.setUpdated_date(detailOrderEntity.getUpdated_date());
        result.setCreated_by(detailOrderEntity.getCreated_by());
        result.setModified_by(detailOrderEntity.getModified_by());
        return result;
    }

    public DetailOrderEntity dtoToEntity(DetailOrderDTO detailOrderDTO){
        DetailOrderEntity result = new DetailOrderEntity();
       /* result.setOrder(detailOrderDTO.getOrder_id());*/
        result.setQuantity(detailOrderDTO.getQuantity());
        result.setPrice(detailOrderDTO.getPrice());
        result.setTotal(detailOrderDTO.getTotal());
        result.setDiscount(detailOrderDTO.getDiscount());
       /* result.setBookEntity();*/
        result.setCreated_date(detailOrderDTO.getCreated_date());
        result.setCreated_by(detailOrderDTO.getCreated_by());
        result.setModified_by(detailOrderDTO.getModified_by());
        return result;
    }

    public OrderEntity dtoToEntity(OrderEntity result, OrderDTO orderDTO){
        result.setTotal_price(orderDTO.getTotal_price());
        result.setCreated_date(orderDTO.getCreated_date());
        result.setCreated_by(orderDTO.getCreated_by());
        result.setModified_by(orderDTO.getModified_by());
        return result;
    }
}
