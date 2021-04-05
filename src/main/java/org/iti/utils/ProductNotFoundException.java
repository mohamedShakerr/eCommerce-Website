package org.iti.utils;

public class ProductNotFoundException extends  RuntimeException{

    public ProductNotFoundException(String errMsg){
        super(errMsg);
    }
}
