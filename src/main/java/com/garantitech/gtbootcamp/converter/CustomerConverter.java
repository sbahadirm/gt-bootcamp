package com.garantitech.gtbootcamp.converter;

import com.garantitech.gtbootcamp.dto.CustomerDTOClass;
import com.garantitech.gtbootcamp.entity.Customer;
import com.garantitech.gtbootcamp.request.CustomerSaveRequestDTOClass;

/**
 * @author bahadirmemis
 */
public class CustomerConverter {

  public static CustomerDTOClass convertToCustomerDTOClass(Customer customer) {
    CustomerDTOClass customerDTOClass = new CustomerDTOClass();
    customerDTOClass.setId(customer.getId());
    customerDTOClass.setName(customer.getName());
    customerDTOClass.setSurname(customer.getSurname());
    customerDTOClass.setUsername(customer.getUsername());
    customerDTOClass.setPhoneNumber(customer.getPhoneNumber());
    customerDTOClass.setEmail(customer.getEmail());
    customerDTOClass.setBirthDate(customer.getBirthDate());
    customerDTOClass.setStatus(customer.getStatus());
    return customerDTOClass;
  }

  public static Customer convertToCustomer(CustomerSaveRequestDTOClass customerSaveRequestDTO) {
    Customer customer = new Customer();
    customer.setName(customerSaveRequestDTO.getName());
    customer.setSurname(customerSaveRequestDTO.getSurname());
    customer.setEmail(customerSaveRequestDTO.getEmail());
    customer.setPhoneNumber(customerSaveRequestDTO.getPhoneNumber());
    customer.setUsername(customerSaveRequestDTO.getUsername());
    customer.setPassword(customerSaveRequestDTO.getPassword());
    customer.setBirthDate(customerSaveRequestDTO.getBirthDate());
    customer.setStatus(customerSaveRequestDTO.getStatus());
    return customer;
  }
}
