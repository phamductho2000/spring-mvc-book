package com.webbansach.controllers.admin;

import com.webbansach.dto.OrderDTO;
import com.webbansach.dto.ReportDTO;
import com.webbansach.service.IBookService;
import com.webbansach.service.IOrderService;
import com.webbansach.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller(value = "reportControllerOfAdmin")
public class ReportController {
    @Autowired
    IOrderService orderService;

    @Autowired
    IBookService bookService;

    @Autowired
    IReportService reportService;

    @RequestMapping(value = "/admin/report", method = RequestMethod.GET)
    public ModelAndView homePage(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                 @RequestParam(value = "limit", defaultValue = "10") int limit) {
        ModelAndView mav = new ModelAndView("admin_report", "listOrder", new ReportDTO() );
        Pageable pageable = new PageRequest(page-1, limit, Sort.Direction.DESC, "createdDate");
        int totalPage = 0;
        if((orderService.getTotalItem() % limit) == 0){
            totalPage = orderService.getTotalItem()/limit;
        }
        else{
            totalPage = (orderService.getTotalItem()/limit) + 1;
        }
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setOrders(orderService.findAll(pageable));
        mav.addObject("listOrder", reportDTO);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        mav.addObject("totalPrice", orderService.getTotalPriceAllOrder());
        return mav;
    }

    @RequestMapping(value = "/admin/report/today", method = RequestMethod.GET)
    public ModelAndView findByCurrentDayPage(){
        ModelAndView mav = new ModelAndView("admin_report", "listOrder", new ReportDTO());
        List<OrderDTO> orderDTOS = orderService.findAllByCurrentDay(null);
        int totalPrice = orderService.getTotalPriceOptionsOrder(orderDTOS);
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setOrders(orderService.findAllByCurrentDay(null));
        mav.addObject("listOrder", reportDTO);
        mav.addObject("totalPrice", totalPrice);
        return mav;
    }

    @RequestMapping(value = "/admin/report/previous-day", method = RequestMethod.GET)
    public ModelAndView findByPreviousDayPage(){
        ModelAndView mav = new ModelAndView("admin_report", "listOrder", new ReportDTO());
        List<OrderDTO> orderDTOS = orderService.findAllByPreviousDay(null);
        int totalPrice = orderService.getTotalPriceOptionsOrder(orderDTOS);
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setOrders(orderService.findAllByPreviousDay(null));
        mav.addObject("listOrder", reportDTO);
        mav.addObject("totalPrice", totalPrice);
        return mav;
    }

    @RequestMapping(value = "/admin/report/current-month", method = RequestMethod.GET)
    public ModelAndView findByCurrentMonthPage(){
        ModelAndView mav = new ModelAndView("admin_report", "listOrder", new ReportDTO());
        List<OrderDTO> orderDTOS = orderService.findAllByCurrentMonth(null);
        int totalPrice = orderService.getTotalPriceOptionsOrder(orderDTOS);
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setOrders(orderService.findAllByCurrentMonth(null));
        mav.addObject("listOrder", reportDTO);
        mav.addObject("totalPrice", totalPrice);
        return mav;
    }

    @RequestMapping(value = "/admin/report/previous-month", method = RequestMethod.GET)
    public ModelAndView findByPreviousMonthPage(){
        ModelAndView mav = new ModelAndView("admin_report", "listOrder", new ReportDTO());
        List<OrderDTO> orderDTOS = orderService.findAllByPreviousMonth(null);
        int totalPrice = orderService.getTotalPriceOptionsOrder(orderDTOS);
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setOrders(orderService.findAllByPreviousMonth(null));
        mav.addObject("listOrder", reportDTO);
        mav.addObject("totalPrice", totalPrice);
        return mav;
    }

    @RequestMapping(value = "/admin/report/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(name = "id", required = false, defaultValue = "0") long id,
                                   @RequestParam(name = "status", required = false, defaultValue = "-1") int status,
                                   @RequestParam(name = "startDate", required = false, defaultValue = "") String startDate,
                                   @RequestParam(name = "endDate", required = false, defaultValue = "") String endDate,
                                   @RequestParam(name = "optionDate", required = false, defaultValue = "") String optionDate,
                                   @RequestParam(name = "limit", required = false, defaultValue = "10") int limit,
                                   @RequestParam(name = "page", required = false, defaultValue = "1") int page) throws ParseException {
        ModelAndView mav = new ModelAndView("admin_report", "listOrder", new ReportDTO());
        ReportDTO reportDTO = new ReportDTO();
        int totalPage = 0, countItem = 0;
        Pageable pageable = new PageRequest(page-1, limit);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        if(startDate.equals("") && endDate.equals("")){
            orderDTOS = orderService.searchOrder(id, status, null, null, optionDate, pageable);
            countItem = orderService.searchOrder(id, status, null, null, optionDate, null).size();
        }
        else if(!startDate.equals("") && endDate.equals("")){
            orderDTOS = orderService.searchOrder(id, status, formatter.parse(startDate), null, optionDate, pageable);
            countItem = orderService.searchOrder(id, status, formatter.parse(startDate), null, optionDate, null).size();
        }
        else if(startDate.equals("") && !endDate.equals("")){
            orderDTOS = orderService.searchOrder(id, status, null, formatter.parse(endDate), optionDate, pageable);
            countItem = orderService.searchOrder(id, status, null, formatter.parse(endDate), optionDate, null).size();
        }
        else {
            orderDTOS = orderService.searchOrder(id, status, formatter.parse(startDate), formatter.parse(endDate) ,optionDate, pageable);
            countItem = orderService.searchOrder(id, status, formatter.parse(startDate), formatter.parse(endDate) ,optionDate, null).size();
        }
        int totalPrice = orderService.getTotalPriceOptionsOrder(orderDTOS);
        if((countItem % limit) == 0){
            totalPage = countItem / limit;
        }
        else{
            totalPage = (countItem / limit) + 1;
        }
        reportDTO.setOrders(orderDTOS);
        mav.addObject("listOrder", reportDTO);
        mav.addObject("totalPrice", totalPrice);
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

    @RequestMapping(value = "/admin/report/export-excel", method = RequestMethod.POST)
    public void exportToExcel(@ModelAttribute("listOrder") ReportDTO reportDTO,
                              HttpServletResponse response) throws IOException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm");
        String currentDateTime = dateFormatter.format(new Date());
        String fileName = "report_" + currentDateTime + ".xlsx";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment; filename="+fileName);
        List<OrderDTO> orders = reportDTO.getOrders();
        reportService.exportToExcel(orders, response);
    }
}
