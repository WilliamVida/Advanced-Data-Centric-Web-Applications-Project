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

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;

@Controller
@SessionAttributes("customer")
public class CustomerController {

	@Autowired
	CustomerService cs;

	@Autowired
	OrderService os;

	@RequestMapping(value = "/addCustomer.html", method = RequestMethod.GET)
	public String addCustomerGET(Model model) {
		Customer c = new Customer();
		model.addAttribute("customer", c);

		return "addCustomer";
	}

	@RequestMapping(value = "/addCustomer.html", method = RequestMethod.POST)
	public String addCustoemrPOST(@Valid @ModelAttribute("customer") Customer c, BindingResult result) {
		if (result.hasErrors()) {
			return "addCustomer";
		}

		cs.save(c);
		return "redirect:showCustomers.html";
	}

	@RequestMapping(value = "/showCustomers.html")
	public String showCustomers(Model model) {
		ArrayList<Customer> customer = cs.findAll();
		model.addAttribute("customer", customer);

		ArrayList<Order> order = os.findAll();
		model.addAttribute("order", order);

		return "showCustomers";
	}

}