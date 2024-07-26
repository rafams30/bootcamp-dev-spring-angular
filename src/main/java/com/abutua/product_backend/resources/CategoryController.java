package com.abutua.product_backend.resources;

import com.abutua.product_backend.models.Category;
import com.abutua.product_backend.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {

    private List<Category> categories = Arrays.asList(
            new Category(1, "Produção propria"),
            new Category(2, "Nacional"),
            new Category(3, "Importado"),
            new Category(4, "Premium")
    );

    @GetMapping("categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {

        Category prod = categories.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found!"));

        return ResponseEntity.ok(prod);
    }

    @GetMapping("categories")
    public List<Category> getCategories() {
        return categories;
    }
}
