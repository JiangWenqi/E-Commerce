package info.jiangwenqi.e_commerce.repository;

import info.jiangwenqi.e_commerce.model.User;
import info.jiangwenqi.e_commerce.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wenqi
 */
public interface WishListRepository extends JpaRepository<WishList, Integer> {

    /**
     * find all the products saved to wishlist for a user
     * sort by latest created date
     *
     * @param user user
     * @return all products order by created date
     */
    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);
}
