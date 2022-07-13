package info.jiangwenqi.e_commerce.controller;

import info.jiangwenqi.e_commerce.common.ApiResponse;
import info.jiangwenqi.e_commerce.model.Category;
import info.jiangwenqi.e_commerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @author Wenqi
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
        if (Objects.nonNull(categoryService.readCategory(category.getCategoryName()))) {
            return new ResponseEntity<>(new ApiResponse(false, "Category already exists"), HttpStatus.CONFLICT);
        }
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "Category created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/update/{categoryID}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") Integer categoryId, @Valid @RequestBody Category category) {
        // check to see if the category exists
        if (Objects.nonNull(categoryService.readCategory(categoryId))) {
            categoryService.updateCategory(categoryId, category);
            return new ResponseEntity<>(new ApiResponse(true, "update category successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false, "category dose not exist"), HttpStatus.NOT_FOUND);
    }
}
