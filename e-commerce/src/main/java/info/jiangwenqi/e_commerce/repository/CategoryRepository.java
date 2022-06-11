package info.jiangwenqi.e_commerce.repository;

import info.jiangwenqi.e_commerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wenqi
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByCategoryName(String categoryName);
}
