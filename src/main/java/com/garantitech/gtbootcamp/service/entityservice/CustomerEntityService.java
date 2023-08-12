package com.garantitech.gtbootcamp.service.entityservice;

import com.garantitech.gtbootcamp.entity.Customer;
import com.garantitech.gtbootcamp.general.BaseAdditionalFields;
import com.garantitech.gtbootcamp.repository.CustomerRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * @author bahadirmemis
 */
@Service
public class CustomerEntityService {

  private CustomerRepository customerRepository;

  public CustomerEntityService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer save(Customer customer){

    BaseAdditionalFields baseAdditionalFields = customer.getBaseAdditionalFields();
    if (baseAdditionalFields == null){
      baseAdditionalFields = new BaseAdditionalFields();
    }

    if (customer.getId() == null){
      // yeni kayıt
      baseAdditionalFields.setCreateDate(LocalDateTime.now());
      //baseAdditionalFields.setCreatedBy(1L);
    }

    baseAdditionalFields.setUpdateDate(LocalDateTime.now());
    customer.setBaseAdditionalFields(baseAdditionalFields);

    customer = customerRepository.save(customer);
    return customer;
  }

  public Optional<Customer> findById(Long id){
    Optional<Customer> customerOptional = customerRepository.findById(id);
    return customerOptional;
  }

  public Customer findByIdWithControl(Long id){
    Optional<Customer> customerOptional = customerRepository.findById(id);
    Customer customer = customerOptional.orElseThrow();
    return customer;
  }

  public List<Customer> findAllByNameAndSurname(String name, String surname){
    List<Customer> customerList = customerRepository.findAllByNameAndSurname(name, surname);
    return customerList;
  }

  public void delete(Customer customer){
    customerRepository.delete(customer);
  }

  public void delete(Long id){
    customerRepository.deleteById(id);
  }

  public List<Customer> findAll(){
    return customerRepository.findAll();
  }
}
