package info.jiangwenqi.e_commerce.controller;

import info.jiangwenqi.e_commerce.common.ApiResponse;
import info.jiangwenqi.e_commerce.dto.cart.AddToCartDto;
import info.jiangwenqi.e_commerce.exception.AuthenticationFailException;
import info.jiangwenqi.e_commerce.exception.CartItemNotExistException;
import info.jiangwenqi.e_commerce.exception.ProductNotExistException;
import info.jiangwenqi.e_commerce.model.AuthenticationToken;
import info.jiangwenqi.e_commerce.model.Product;
import info.jiangwenqi.e_commerce.model.User;
import info.jiangwenqi.e_commerce.service.AuthenticationTokenService;
import info.jiangwenqi.e_commerce.service.CartService;
import info.jiangwenqi.e_commerce.service.CategoryService;
import info.jiangwenqi.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author wenqi
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    AuthenticationTokenService authenticationTokenService;

    @Autowired
    CartService cartService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token)
            throws ProductNotExistException, AuthenticationFailException {
        // first authenticate the token
        authenticationTokenService.authenticate(token);

        // get the user
        User user = authenticationTokenService.getUser(token);

        // find the product to add and add item by service
        Product product = productService.getProductById(addToCartDto.getProductId());
        cartService.addToCart(addToCartDto, product, user);

        // return response
        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }

    // task delete cart item
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int cartItemId,
                                                      @RequestParam("token") String token)
            throws AuthenticationFailException, CartItemNotExistException {
        authenticationTokenService.authenticate(token);
        User user = authenticationTokenService.getUser(token);
        // method to be completed
        cartService.deleteCartItem(cartItemId, user);
        return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }


}