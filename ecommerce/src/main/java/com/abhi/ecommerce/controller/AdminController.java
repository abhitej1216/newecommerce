package com.abhi.ecommerce.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping(value = "/admin")
    public String adminHome() {
        return "adminHome";
    }
        @GetMapping(value = "/admin/categories")
                public String getCat(){
            return "categories";
        }
    @GetMapping(value = "/admin/categories/add")
    public String getCatAdd(){
        return "categoriesAdd";
    }
    }

