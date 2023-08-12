package com.garantitech.gtbootcamp.contract.impl;

import com.garantitech.gtbootcamp.contract.CustomerControllerContract;
import com.garantitech.gtbootcamp.converter.CustomerConverter;
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

    Customer customer = CustomerConverter.convertToCustomer(customerSaveRequestDTO);

    customer = customerEntityService.save(customer);

    CustomerDTOClass customerDTOClass = CustomerConverter.convertToCustomerDTOClass(customer);

    return customerDTOClass;
  }

}
