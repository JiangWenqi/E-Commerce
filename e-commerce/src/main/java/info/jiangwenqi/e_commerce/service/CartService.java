package info.jiangwenqi.e_commerce.service;

import info.jiangwenqi.e_commerce.dto.cart.AddToCartDto;
import info.jiangwenqi.e_commerce.exception.CartItemNotExistException;
import info.jiangwenqi.e_commerce.model.Cart;
import info.jiangwenqi.e_commerce.model.Product;
import info.jiangwenqi.e_commerce.model.User;
import info.jiangwenqi.e_commerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wenqi
 */
@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public void addToCart(AddToCartDto addToCartDto, Product product, User user) {
        Cart cart = new Cart(product, addToCartDto.getQuantity(), user);
        cartRepository.save(cart);
    }

    public void deleteCartItem(int cartItemId, User user) throws CartItemNotExistException {

        // first check if cartItemId is valid else throw an CartItemNotExistException

        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);

        if (optionalCart.isEmpty()) {
            throw new CartItemNotExistException("cartItemId not valid");
        }

        // next check if the cartItem belongs to the user else throw CartItemNotExistException exception

        Cart cart = optionalCart.get();

        if (cart.getUser() != user) {
            throw new CartItemNotExistException("cart item does not belong to user");
        }

        cartRepository.deleteById(cartItemId);
        // delete the cart item
    }
}
