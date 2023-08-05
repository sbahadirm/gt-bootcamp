package com.garantitech.gtbootcamp.service.entityservice;

import com.garantitech.gtbootcamp.entity.Customer;
import com.garantitech.gtbootcamp.repository.CustomerRepository;
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
    customer = customerRepository.save(customer);
    return customer;
  }

  public Customer findById(Long id){
    Optional<Customer> customerOptional = customerRepository.findById(id);
    return customerOptional.get();
  }

  public List<Customer> findAllByNameAndSurname(String name, String surname){
    List<Customer> customerList = customerRepository.findAllByNameAndSurname(name, surname);
    return customerList;
  }
}
