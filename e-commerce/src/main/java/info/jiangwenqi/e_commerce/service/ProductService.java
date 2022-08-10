package info.jiangwenqi.e_commerce.service;

import info.jiangwenqi.e_commerce.dto.product.ProductDto;
import info.jiangwenqi.e_commerce.exception.ProductNotExistException;
import info.jiangwenqi.e_commerce.model.Category;
import info.jiangwenqi.e_commerce.model.Product;
import info.jiangwenqi.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wenqi
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        productRepository.save(product);
    }

    public List<ProductDto> listProducts() {
        // first fetch all the products
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : products) {
            // for each product change it to DTO
            productDtos.add(new ProductDto(product));
        }
        return productDtos;
    }

    public void updateProduct(Integer productId, ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        // set the id for updating
        product.setId(productId);
        // update
        productRepository.save(product);
    }

    public Product getProductFromDto(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        return product;
    }

    public Product getProductById(Integer productId) throws ProductNotExistException {
        Optional<Product> optionalProducts = productRepository.findById(productId);
        if (optionalProducts.isEmpty()) {
            throw new ProductNotExistException("Product id is invalid " + productId);
        }
        return optionalProducts.get();
    }
}
