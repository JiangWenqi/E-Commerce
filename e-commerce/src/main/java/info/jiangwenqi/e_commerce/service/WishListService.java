package info.jiangwenqi.e_commerce.service;

import info.jiangwenqi.e_commerce.model.User;
import info.jiangwenqi.e_commerce.model.WishList;
import info.jiangwenqi.e_commerce.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenqi
 */
@Service
public class WishListService {
    @Autowired
    private WishListRepository wishListRepository;

    public void createWishlist(WishList wishList) {
        wishListRepository.save(wishList);
    }

    public List<WishList> readWishList(User user) {
        return wishListRepository.findAllByUserOrderByCreatedDateDesc(user);
    }
}
