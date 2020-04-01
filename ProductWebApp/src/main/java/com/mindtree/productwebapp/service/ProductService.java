package com.mindtree.productwebapp.service;

import java.util.List;

import com.mindtree.productwebapp.entity.Product;

public interface ProductService {

	public List<Product> listAll();

	public void save(Product product);

	public Product get(long id);

	public void delete(long id);

	public void update(Product product, long id);

}
