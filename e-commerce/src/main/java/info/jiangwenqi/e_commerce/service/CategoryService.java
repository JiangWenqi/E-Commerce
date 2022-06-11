package info.jiangwenqi.e_commerce.service;

import info.jiangwenqi.e_commerce.model.Category;
import info.jiangwenqi.e_commerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Note: The repository talks to the model, the service talks to the repository, and the controller talks to the service.
 *
 * @author wenqi
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category readCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }


}
