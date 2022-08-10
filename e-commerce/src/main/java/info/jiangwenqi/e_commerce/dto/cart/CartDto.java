package info.jiangwenqi.e_commerce.dto.cart;

import java.util.List;

/**
 * @author wenqi
 */
public class CartDto {
    private List<CartItemDto> cartItems;

    private double totalCost;

    public CartDto(List<CartItemDto> cartItems, double totalCost) {
        this.cartItems = cartItems;
        this.totalCost = totalCost;
    }


    public List<CartItemDto> getcartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItemDtoList) {
        this.cartItems = cartItemDtoList;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
