package com.garantitech.gtbootcamp.contract.impl;

import com.garantitech.gtbootcamp.contract.CustomerControllerContract;
import com.garantitech.gtbootcamp.dto.CustomerDTOClass;
import com.garantitech.gtbootcamp.entity.Customer;
import com.garantitech.gtbootcamp.request.CustomerSaveRequestDTOClass;
import com.garantitech.gtbootcamp.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
@RequiredArgsConstructor
public class CustomerControllerContractImpl implements CustomerControllerContract {

  private final CustomerEntityService customerEntityService;

  @Override
  public Customer save(Customer customer) {
    return customerEntityService.save(customer);
  }

  @Override
  public CustomerDTOClass save1(CustomerSaveRequestDTOClass customerSaveRequestDTO) {

    Customer customer = new Customer();
    customer.setName(customerSaveRequestDTO.getName());
    customer.setSurname(customerSaveRequestDTO.getSurname());
    customer.setEmail(customerSaveRequestDTO.getEmail());
    customer.setPhoneNumber(customerSaveRequestDTO.getPhoneNumber());
    customer.setUsername(customerSaveRequestDTO.getUsername());
    customer.setPassword(customerSaveRequestDTO.getPassword());
    customer.setBirthDate(customerSaveRequestDTO.getBirthDate());
    customer.setStatus(customerSaveRequestDTO.getStatus());

    customer = customerEntityService.save(customer);

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
}
