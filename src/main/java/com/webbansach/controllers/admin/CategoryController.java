package com.webbansach.controllers.admin;
import com.webbansach.dto.CategoryDTO;
import com.webbansach.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "categoryControllerOfAdmin")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @RequestMapping(value = "/admin/category", method = RequestMethod.GET)
    public ModelAndView categoryPage(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("admin_category");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        if((categoryService.getTotalItem() % 8) == 0){
            totalPage = categoryService.getTotalItem()/8;
        }
        else{
            totalPage = (categoryService.getTotalItem()/8) + 1;
        }
        mav.addObject("listCategory", categoryService.findAll(pageable));
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }

    @RequestMapping(value = "/admin/category/new", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView("admin_category_new", "category", new CategoryDTO());
        return mav;
    }

    @RequestMapping(value = "/admin/category/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("book") CategoryDTO category) {
        categoryService.save(category);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/admin/category/remove", method = RequestMethod.POST)
    public String removeBook(@RequestParam("currentUrl") String url, @RequestParam("id") long id) {
        categoryService.remove(id);
        return "redirect:"+url;
    }

    @RequestMapping(value = "/admin/category/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView("admin_category_edit", "category", new CategoryDTO());
        mav.addObject("category", categoryService.findOne(id));
        return mav;
    }

    @RequestMapping(value = "/admin/category/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("book") CategoryDTO category) {
        categoryService.save(category);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/admin/category/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam(name = "key") String key,
                               @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        ModelAndView mav = new ModelAndView("admin_category");
        Pageable pageable = new PageRequest(page-1, 8);
        int totalPage = 0;
        int countItem = categoryService.search(key, null).size();
        if((countItem % 8) == 0){
            totalPage = countItem/8;
        }
        else{
            totalPage = (countItem/8) + 1;
        }
        mav.addObject("listCategory", categoryService.search(key, pageable));
        mav.addObject("totalPage", totalPage);
        mav.addObject("currentPage", page);
        return mav;
    }
}
