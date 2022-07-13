package info.jiangwenqi.e_commerce.controller;

import info.jiangwenqi.e_commerce.common.ApiResponse;
import info.jiangwenqi.e_commerce.dto.product.ProductDto;
import info.jiangwenqi.e_commerce.model.Category;
import info.jiangwenqi.e_commerce.service.CategoryService;
import info.jiangwenqi.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author wenqi
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse(false, "Category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.addProduct(productDto, category);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been added"), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts() {
        // should list all the products
        List<ProductDto> body = productService.listProducts();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId, @RequestBody @Valid ProductDto productDto) {
        // should update a product, when productDTO is passed in body
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.updateProduct(productId, productDto, category);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }
}
