package com.webbansach.controllers.admin;
import com.webbansach.dto.CategoryDTO;
import com.webbansach.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "categoryControllerOfAdmin")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @RequestMapping(value = "/admin/category", method = RequestMethod.GET)
    public ModelAndView categoryPage() {
        ModelAndView mav = new ModelAndView("admin_category");
        mav.addObject("listCategory", categoryService.findAll());
        return mav;
    }

    @RequestMapping(value = "/admin/category/new", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView("admin_category_new", "category", new CategoryDTO());
        return mav;
    }

    @RequestMapping(value = "/admin/category/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") CategoryDTO category) {
        categoryService.save(category);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/admin/category/remove/{id}", method = RequestMethod.GET)
    public String removeBook(@PathVariable("id") long id) {
        categoryService.remove(id);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/admin/category/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView("admin_category_edit", "category", new CategoryDTO());
        mav.addObject("category", categoryService.findOne(id));
        return mav;
    }

    @RequestMapping(value = "/admin/category/update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book") CategoryDTO category) {
        categoryService.save(category);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/admin/category/search", method = RequestMethod.POST)
    public ModelAndView searchBook(@RequestParam(name = "key") String key) {
        System.out.println(key);

        return new ModelAndView("admin_book");
    }
}
