package com.garantitech.gtbootcamp.contract.impl;

import com.garantitech.gtbootcamp.contract.CustomerControllerContract;
import com.garantitech.gtbootcamp.converter.CustomerConverter;
import com.garantitech.gtbootcamp.dto.CustomerDTO;
import com.garantitech.gtbootcamp.dto.CustomerDTOClass;
import com.garantitech.gtbootcamp.entity.Customer;
import com.garantitech.gtbootcamp.mapper.CustomerMapper;
import com.garantitech.gtbootcamp.request.CustomerSaveRequestDTO;
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
  public Customer save2(Customer customer) {
    return customerEntityService.save(customer);
  }

  @Override
  public CustomerDTOClass save1(CustomerSaveRequestDTOClass customerSaveRequestDTO) {

    Customer customer = CustomerConverter.convertToCustomer(customerSaveRequestDTO);

    customer = customerEntityService.save(customer);

    CustomerDTOClass customerDTOClass = CustomerConverter.convertToCustomerDTOClass(customer);

    return customerDTOClass;
  }

  @Override
  public CustomerDTO save(CustomerSaveRequestDTO customerSaveRequestDTO) {
    Customer customer = CustomerMapper.INSTANCE.convertToCustomer(customerSaveRequestDTO);
    customer  = customerEntityService.save(customer);
    CustomerDTO customerDTO = CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    return customerDTO;
  }
}
