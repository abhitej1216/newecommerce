package com.abhi.ecommerce.controller;
import com.abhi.ecommerce.model.Category;
import com.abhi.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @GetMapping(value = "/admin")
    public String adminHome() {
        return "adminHome";
    }
        @GetMapping(value = "/admin/categories")
                public String getCat(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
            return "categories";
        }
    @GetMapping(value = "/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }
    @PostMapping(value = "/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category){

            categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent())
        {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        }
        else
            return "404";
    }
    @GetMapping("/admin/products")
    public String deleteCat(Model model){
        model.addAttribute()
    }
    }

