package com.mindtree.productwebapp.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.productwebapp.entity.Product;
import com.mindtree.productwebapp.repository.ProductRepository;
import com.mindtree.productwebapp.service.ProductService;

@Service
public class ProductServiceimpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	public void save(Product product) {
		repo.save(product);
	}

	public List<Product> listAll() {
		return repo.findAll();
	}

	public Product get(long id) {
		return repo.findById(id).get();
	}

	public void update(Product product, long id) {
		Product product2= repo.findById(id).get(); 
		product2.setName(product.getName());
		product2.setPrice(product.getPrice());
		repo.save(product2);
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}
