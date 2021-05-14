package com.bank.dao;

import java.util.List;

import com.bank.model.Customer;

public interface CustomerDao {

	String addCustomer(List<Customer> customer);

	List<Customer> displayCustomerDetails();

}
