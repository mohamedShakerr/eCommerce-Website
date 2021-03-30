package org.iti.dtos;

import java.util.List;

public class FilterCriteria {

    double minPrice;
    double maxPrice;
    List<Integer> categories;


    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }


    @Override
    public String toString() {
        return "FilterCriteria{" +
                "minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", categories=" + categories +
                '}';
    }
}
