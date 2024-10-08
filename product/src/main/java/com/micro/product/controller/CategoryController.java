package com.micro.product.controller;


import com.micro.product.dto.CategoryRequest;
import com.micro.product.dto.CategoryResponse;
import com.micro.product.dto.ProductRequest;
import com.micro.product.dto.ProductResponse;
import com.micro.product.service.CategoryService;
import com.micro.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    //Admin Routes
    @PostMapping("admin/products/categories/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@ModelAttribute CategoryRequest categoryRequest, @RequestParam("imageFile") MultipartFile file) {
        categoryService.createCategory(categoryRequest);
    }

    @GetMapping("admin/products/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getProducts() {
        return categoryService.getAllCategories();
    }
    //Visitor Routes

    @GetMapping("products/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getCategories() {
        return categoryService.getAllCategories();
    }
}
