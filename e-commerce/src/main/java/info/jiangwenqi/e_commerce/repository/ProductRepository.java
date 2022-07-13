package info.jiangwenqi.e_commerce.repository;


import info.jiangwenqi.e_commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wenqi
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
