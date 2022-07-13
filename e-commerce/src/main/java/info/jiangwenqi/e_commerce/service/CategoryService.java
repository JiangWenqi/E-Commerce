package info.jiangwenqi.e_commerce.service;

import info.jiangwenqi.e_commerce.model.Category;
import info.jiangwenqi.e_commerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Note: The repository talks to the model, the service talks to the repository, and the controller talks to the service.
 *
 * @author wenqi
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Find the category by its name
     *
     * @param categoryName the name of category
     * @return the category
     */
    public Category readCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }


    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> readCategory(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public void updateCategory(Integer categoryId, Category category) {
        Category oldCategory = categoryRepository.findById(categoryId).get();
        oldCategory.setCategoryName(category.getCategoryName());
        oldCategory.setDescription(category.getDescription());
        oldCategory.setImageUrl(category.getImageUrl());
        categoryRepository.save(oldCategory);
    }
}
