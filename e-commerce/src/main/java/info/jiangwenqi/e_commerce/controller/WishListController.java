package info.jiangwenqi.e_commerce.controller;

import info.jiangwenqi.e_commerce.common.ApiResponse;
import info.jiangwenqi.e_commerce.dto.product.ProductDto;
import info.jiangwenqi.e_commerce.exception.AuthenticationFailException;
import info.jiangwenqi.e_commerce.model.Product;
import info.jiangwenqi.e_commerce.model.User;
import info.jiangwenqi.e_commerce.model.WishList;
import info.jiangwenqi.e_commerce.repository.ProductRepository;
import info.jiangwenqi.e_commerce.service.AuthenticationTokenService;
import info.jiangwenqi.e_commerce.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WishListController {
    @Autowired
    WishListService wishListService;

    @Autowired
    AuthenticationTokenService authenticationTokenService;

    @Autowired
    private ProductRepository productRepository;

    /**
     * API to add a new product in wishlist
     */
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addWishList(@RequestBody ProductDto productDto, @RequestParam("token") String token) throws AuthenticationFailException {
        // first authenticate if the token is valid
        authenticationTokenService.authenticate(token);
        // then fetch the user linked to the token
        User user = authenticationTokenService.getUser(token);

        // get the product from product repo
        Product product = productRepository.getReferenceById(productDto.getId());

        // save wish list
        WishList wishList = new WishList(user, product);
        wishListService.createWishlist(wishList);

        return new ResponseEntity<>(new ApiResponse(true, "Added to wishlist"), HttpStatus.CREATED);
    }

    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("token") String token) throws AuthenticationFailException {
        // first authenticate if the token is valid
        authenticationTokenService.authenticate(token);
        // then fetch the user linked to the token
        User user = authenticationTokenService.getUser(token);
        // first retrieve the wishlist items
        List<WishList> wishLists = wishListService.readWishList(user);

        List<ProductDto> products = new ArrayList<>();
        for (WishList wishList : wishLists) {
            // change each product to product DTO
            products.add(new ProductDto(wishList.getProduct()));
        }
        // send the response to user
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}