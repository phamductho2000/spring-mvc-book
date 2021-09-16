package com.webbansach.controllers.admin;

import com.webbansach.dto.VoucherDTO;
import com.webbansach.service.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller(value = "voucherControllerOfAdmin")
public class VoucherController {

    @Autowired
    IVoucherService voucherService;

    @RequestMapping(value = "/admin/voucher", method = RequestMethod.GET)
    public ModelAndView voucherPage(@RequestParam(value = "page", required = false, defaultValue = "1") int page){
        ModelAndView mav = new ModelAndView("admin_voucher");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        int countItem = voucherService.findAll(null).size();
        if(countItem % 8 == 0){
            totalPage = countItem/8;
        }
        else{
            totalPage = (countItem/8) + 1;
        }
        mav.addObject("listVoucher", voucherService.findAll(pageable));
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

    @RequestMapping(value = "/admin/voucher/new", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView("admin_voucher_new", "voucher", new VoucherDTO());
        return mav;
    }

    @RequestMapping(value = "/admin/voucher/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") long id) throws ParseException {
        ModelAndView mav = new ModelAndView("admin_voucher_edit", "voucher", new VoucherDTO());
        VoucherDTO voucherDTO = voucherService.findOne(id);
        mav.addObject("voucher", voucherDTO);
        return mav;
    }

    @RequestMapping(value = "/admin/voucher/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("voucher") VoucherDTO  voucherDTO,
                       @RequestParam("expirationDate") String expirationDate) throws ParseException {

        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(expirationDate);
        voucherDTO.setExpirationDate(date);
        voucherService.save(voucherDTO);
        return "redirect:/admin/voucher";
    }

    @RequestMapping(value = "/admin/voucher/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("currentUrl") String url, @RequestParam("id") long id) {
        voucherService.remove(id);
        return "redirect:"+url;
    }

    @RequestMapping(value = "/admin/voucher/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam(name = "code") String code,
                               @RequestParam(name = "discount", required = false, defaultValue = "0") int discount,
                               @RequestParam(name = "status") int status,
                               @RequestParam(name = "expiration") String expiration,
                               @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("admin_voucher");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        int countItem = voucherService.search(code, discount, status, expiration, null).size();
        if((countItem % 8) == 0){
            totalPage = countItem/8;
        }
        else{
            totalPage = (countItem/8) + 1;
        }
        mav.addObject("listVoucher", voucherService.search(code, discount, status, expiration, pageable));
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }
}
