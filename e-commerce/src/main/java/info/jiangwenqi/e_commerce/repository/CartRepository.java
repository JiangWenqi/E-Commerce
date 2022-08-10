package info.jiangwenqi.e_commerce.repository;

import info.jiangwenqi.e_commerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wenqi
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
