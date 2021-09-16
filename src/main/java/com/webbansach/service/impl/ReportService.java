package com.webbansach.service.impl;

import com.webbansach.dto.OrderDTO;
import com.webbansach.service.IOrderService;
import com.webbansach.service.IReportService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService implements IReportService {

    @Autowired
    IOrderService orderService;

    @Override
    public void exportToExcel(List<OrderDTO> orders, HttpServletResponse response) throws IOException {
        Workbook wb = new XSSFWorkbook();
        XSSFSheet sheet = (XSSFSheet) wb.createSheet("Báo cáo doanh thu");
        //font
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        //style
        CellStyle cellStyleDate = wb.createCellStyle();
        CellStyle cellStyle = wb.createCellStyle();
        CreationHelper createHelper = wb.getCreationHelper();
        cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy h:mm"));
        cellStyle.setFont(font);
        int rownum = 0;
        Cell cell;
        Row row;
        row = sheet.createRow(rownum);
        //Title cell 0
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã đơn hàng");
        cell.setCellStyle(cellStyle);
        //Title cell 1
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Khách hàng");
        cell.setCellStyle(cellStyle);
        //Title cell 2
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Tình trạng");
        cell.setCellStyle(cellStyle);
        //Title cell 3
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Ngày bán");
        cell.setCellStyle(cellStyle);
        //Title cell 4
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Tổng tiền");
        cell.setCellStyle(cellStyle);
        //bind Data
        for(OrderDTO item: orders){
            rownum++;
            row = sheet.createRow(rownum);
            //Bind Data cell 0
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(item.getId());
            //Bind Data cell 1
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(item.getUser_name());
            //Bind Data cell 2
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(item.getStatus());
            //Bind Data cell 3
            cell = row.createCell(3);
            cell.setCellValue(item.getCreated_date());
            cell.setCellStyle(cellStyleDate);
            //Bind Data cell 4
            cell = row.createCell(4, CellType.NUMERIC);
            cell.setCellValue(item.getTotal_price());

        }
        //calculator total price
        rownum++;
        row = sheet.createRow(rownum);
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("TỔNG");
        cell = row.createCell(4, CellType.NUMERIC);
        cell.setCellValue(orderService.getTotalPriceOptionsOrder(orders));
        //
        ServletOutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        wb.close();
        outputStream.close();
    }
}
