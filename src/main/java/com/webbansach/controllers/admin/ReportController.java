package com.webbansach.controllers.admin;

import com.webbansach.dto.OrderDTO;
import com.webbansach.dto.ReportDTO;
import com.webbansach.service.IBookService;
import com.webbansach.service.IOrderService;
import com.webbansach.service.IReportService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;
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
    public ModelAndView homePage(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("admin_report", "listOrder", new ReportDTO() );
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        if((orderService.getTotalItem() % 8) == 0){
            totalPage = orderService.getTotalItem()/8;
        }
        else{
            totalPage = (orderService.getTotalItem()/8) + 1;
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

    @RequestMapping(value = "/admin/report/search", method = RequestMethod.POST)
    public ModelAndView searchBook(@RequestParam(name = "id", defaultValue = "0") int id,
                                   @RequestParam(name = "status") int status,
                                   @RequestParam(name = "startDate", defaultValue = "") String startDate,
                                   @RequestParam(name = "endDate", defaultValue = "") String endDate,
                                   @RequestParam(name = "page", required = false) int page) throws ParseException {
        ModelAndView mav = new ModelAndView("admin_report", "listOrder", new ReportDTO());
        ReportDTO reportDTO = new ReportDTO();
        List<OrderDTO> orderDTOS = orderService.search(id, status, startDate, endDate ,null);
        int totalPrice = orderService.getTotalPriceOptionsOrder(orderDTOS);
        reportDTO.setOrders(orderDTOS);
        mav.addObject("listOrder", reportDTO);
        mav.addObject("totalPrice", totalPrice);
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
