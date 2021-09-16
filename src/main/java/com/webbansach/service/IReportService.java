package com.webbansach.service;

import com.webbansach.dto.OrderDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IReportService {
    void exportToExcel(List<OrderDTO> orders, HttpServletResponse response) throws IOException;
}
