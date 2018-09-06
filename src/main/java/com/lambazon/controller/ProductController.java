package com.lambazon.controller;

import javax.inject.Inject;

import com.lambazon.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lambazon.service.ProductService;
/**
 * Import List for calculateTotalInventoryAmount
 */
import java.util.List;


@Controller
public class ProductController {

	@Inject
	private ProductService productService;

	@GetMapping("/products")
	public String products (Model model) {
		model.addAttribute("prods", productService.products());
		model.addAttribute("totalInventoryAmount", calculateTotalInventoryAmount(productService.products()));
		return "products";
	}

	@GetMapping("/products/{id}/details")
	public String product (@PathVariable Integer id, Model model) {
		model.addAttribute("prod", productService.product(id));
		return "product";
	}

	/**
	 *Definition of calculating the total inventory value by summing the value of the inventory for each of the products.
	 */
	private double calculateTotalInventoryAmount( List<Product> products ) {
		double total = 0;
		for ( Product product : products ) {
			double k = product.getInventoryPrice();
			total = total + k;
		}
		return total;
	}
}
