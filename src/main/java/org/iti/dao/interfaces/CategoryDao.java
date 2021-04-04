package org.iti.dao.interfaces;

import org.iti.db.domain.Categories;
import org.iti.db.domain.Products;

import java.util.List;

public interface CategoryDao {

    List<Categories> getAllCategories();

    Categories getCategoryByProdId(Integer prodId);

    boolean isCategoryExist(Integer categoryId);

    void addCategory(Categories addedCat);

    Categories getCategoryById(Integer categoryId);
}
