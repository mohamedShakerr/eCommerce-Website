package org.iti.dao.interfaces;

import org.iti.db.domain.FeaturedAccesory;
import org.iti.db.domain.FeaturedProds;

import java.util.List;

public interface FeaturedProductDao {


    public void addFeaturedProduct(FeaturedProds featuredProds);

    public List<FeaturedProds> getAllFeaturedProducts();

    public FeaturedProds getFeaturedProdsBytId(Integer id);

    public List<FeaturedAccesory> getAllFeaturedAccessories();
}
