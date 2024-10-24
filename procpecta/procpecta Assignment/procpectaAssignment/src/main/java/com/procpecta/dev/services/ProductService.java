package com.procpecta.dev.services;

import java.util.List;

import com.procpecta.dev.domain.Product;

public interface ProductService {
    public List<Product> GetProductByCategory(String cat) throws Exception;

    public Product CreateProduct(Product in) throws Exception;

}
