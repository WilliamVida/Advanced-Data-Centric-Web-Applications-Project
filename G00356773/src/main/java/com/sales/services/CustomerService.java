package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository cr;

	public ArrayList<Customer> findAll() {
		return (ArrayList<Customer>) cr.findAll();
	}

	public Customer findCust(Long cid) {
		return cr.findOne(cid);
	}

	public void save(Customer c) {
		cr.save(c);
	}

}
