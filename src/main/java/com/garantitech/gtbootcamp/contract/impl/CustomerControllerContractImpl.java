package com.garantitech.gtbootcamp.contract.impl;

import com.garantitech.gtbootcamp.contract.CustomerControllerContract;
import com.garantitech.gtbootcamp.converter.CustomerConverter;
import com.garantitech.gtbootcamp.dto.CustomerDTO;
import com.garantitech.gtbootcamp.dto.CustomerDTOClass;
import com.garantitech.gtbootcamp.entity.Customer;
import com.garantitech.gtbootcamp.enums.EnumStatus;
import com.garantitech.gtbootcamp.mapper.CustomerMapper;
import com.garantitech.gtbootcamp.request.CustomerSaveRequestDTO;
import com.garantitech.gtbootcamp.request.CustomerSaveRequestDTOClass;
import com.garantitech.gtbootcamp.request.CustomerUpdateRequestDTO;
import com.garantitech.gtbootcamp.service.entityservice.CustomerEntityService;
import java.util.List;
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

  @Override
  public List<CustomerDTO> findAll() {
    List<Customer> customerList = customerEntityService.findAll();

    //List<CustomerDTO> customerDTOList = new ArrayList<>();
    //for (Customer customer : customerList) {
    //  CustomerDTO customerDTO = CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    //  customerDTOList.add(customerDTO);
    //}
    List<CustomerDTO> customerDTOList = CustomerMapper.INSTANCE.convertToCustomerDTOList(customerList);

    return customerDTOList;
  }

  @Override
  public CustomerDTO findById(Long id) {
    Customer customer = customerEntityService.findByIdWithControl(id);
    CustomerDTO customerDTO = CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    return customerDTO;
  }

  @Override
  public CustomerDTO update(CustomerUpdateRequestDTO dto) {

    Customer customer = customerEntityService.findByIdWithControl(dto.id());
    CustomerMapper.INSTANCE.updateCustomer(dto, customer);

    customer = customerEntityService.save(customer);
    CustomerDTO customerDTO = CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    return customerDTO;
  }

  @Override
  public CustomerDTO deactivate(Long id) {

    Customer customer = customerEntityService.findByIdWithControl(id);
    customer.setStatus(EnumStatus.PASSIVE);
    customer = customerEntityService.save(customer);
    CustomerDTO customerDTO = CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    return customerDTO;
  }
}
