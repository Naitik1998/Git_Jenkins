package com.mindtree.productwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.productwebapp.entity.Product;
import com.mindtree.productwebapp.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}

	@RequestMapping(value = "/save")
	public String saveProduct(@ModelAttribute("product") Product product) {

		service.save(product);

		return "redirect:/";
	}

	@RequestMapping(value = "/displayproduct")
	public String getProduct(Model model) {
		List<Product> listProducts = service.listAll();

		model.addAttribute("productlist", listProducts);

		return "displayproduct";
	}

	@RequestMapping(value = "{id}")
	public String deteleProduct(@PathVariable long id) {

		service.delete(id);

		return "redirect:/displayproduct";

	}

	@RequestMapping(value = "/editproduct/{id}")
	public String editProduct(@PathVariable int id, Model model) {
		model.addAttribute("product", service.get(id));
		return "editproduct";
	}

	@RequestMapping(value = "/editproduct/{id}/editsave")
	public String editProductSave(@ModelAttribute("product") Product product, @PathVariable long id) {
		service.update(product,id);
		return "redirect:/displayproduct";
	}
}
