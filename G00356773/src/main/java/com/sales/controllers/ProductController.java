package com.sales.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
@SessionAttributes("product")
public class ProductController {

	@Autowired
	ProductService ps;

	@RequestMapping(value = "/addProduct.html", method = RequestMethod.GET)
	public String addProductGET(Model model) {
		Product p = new Product();
		model.addAttribute("product", p);

		return "addProduct";
	}

	@RequestMapping(value = "/addProduct.html", method = RequestMethod.POST)
	public String addProductPOST(@Valid @ModelAttribute("product") Product p, BindingResult result) {
		if (result.hasErrors()) {
			return "addProduct";
		}

		ps.save(p);
		return "redirect:showProducts.html";
	}

	@RequestMapping(value = "/showProducts.html")
	public String showProducts(Model model) {
		ArrayList<Product> product = ps.findAll();
		model.addAttribute("product", product);

		return "showProducts";
	}

}
