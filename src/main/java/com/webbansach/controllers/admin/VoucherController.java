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
    public ModelAndView homePage(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                 @RequestParam(value = "limit", defaultValue = "10") int limit){
        ModelAndView mav = new ModelAndView("admin_voucher");
        Pageable pageable = new PageRequest(page-1, limit);
        int totalPage = 0;
        int countItem = voucherService.findAll(null).size();
        if(countItem % limit == 0){
            totalPage = countItem/limit;
        }
        else{
            totalPage = (countItem/limit) + 1;
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

    @RequestMapping(value = "/admin/voucher/removeByIds", method = RequestMethod.POST)
    public String removes(@RequestParam("currentUrl") String url, @RequestParam("ids") Long[] ids) {
        voucherService.remove(ids);
        return "redirect:"+url;
    }

    @RequestMapping(value = "/admin/voucher/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(name = "code", required = false, defaultValue = "default") String code,
                               @RequestParam(name = "discount", required = false, defaultValue = "0") int discount,
                               @RequestParam(name = "status", required = false, defaultValue = "-1") int status,
                               @RequestParam(name = "expiration", required = false, defaultValue = "default") String expiration,
                               @RequestParam(value = "limit", defaultValue = "10") int limit,
                               @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("admin_voucher");
        Pageable pageable = new PageRequest(page-1, limit);
        int totalPage = 0;
        int countItem = voucherService.search(code, discount, status, expiration, null).size();
        if((countItem % limit) == 0){
            totalPage = countItem/limit;
        }
        else{
            totalPage = (countItem/limit) + 1;
        }
        mav.addObject("listVoucher", voucherService.search(code, discount, status, expiration, pageable));
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }
}
