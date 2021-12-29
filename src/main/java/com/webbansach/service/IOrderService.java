package com.webbansach.service;

import com.webbansach.dto.DetailOrderDTO;
import com.webbansach.dto.OrderDTO;
import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

public interface IOrderService {
    List<OrderDTO> findAll(Pageable pageable);

    List<OrderDTO> findAllByUserId(long id, Pageable pageable);

    List<DetailOrderDTO> findAllDetailOrder(long orderId);

    List<OrderDTO> findAllByCurrentDay(Pageable pageable);

    List<OrderDTO> findAllNewOrder(Pageable pageable);

    OrderDTO findOne(long id);

    List<OrderDTO> findAllByPreviousDay(Pageable pageable);

    List<OrderDTO> findAllByCurrentMonth(Pageable pageable);

    List<OrderDTO> findAllByPreviousMonth(Pageable pageable);

//    List<OrderDTO> search(int id, int status, String startDate, String endDate, Pageable pageable);

    List<OrderDTO> searchOrder(long id, int status, Date startDate, Date endDate, String optionDate, Pageable pageable);

    List<OrderDTO> findAllByStatus(int status, Pageable pageable);

    void save(OrderDTO orderDTO);

    int getTotalItem();

    int getTotalPriceAllOrder();

    int getTotalPriceOptionsOrder(List<OrderDTO> orderDTOS);
}
