package com.garantitech.gtbootcamp.controller;

import com.garantitech.gtbootcamp.entity.Customer;
import com.garantitech.gtbootcamp.service.entityservice.CustomerEntityService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 3 farklı injection şekli var.
 * 1. field injection
 * 2. setter injection
 * 3. constructor injection
 *
 * @author bahadirmemis
 */
//@RestController
@RequestMapping("/api/v1/customers")
public class DeletedCustomerController2 {

  //@Autowired // field inj.
  //private CustomerRepository customerRepository;

  //@Autowired // setter inj.
  //public void setCustomerRepository(CustomerRepository customerRepository) {
  //  this.customerRepository = customerRepository;
  //}

  //public CustomerController(CustomerRepository customerRepository) { // constructor inj.
  //  this.customerRepository = customerRepository;
  //}

  private CustomerEntityService customerEntityService;

  public DeletedCustomerController2(CustomerEntityService customerEntityService) {
    this.customerEntityService = customerEntityService;
  }

  @PostMapping
  public Customer save(@RequestBody Customer customer) {
    customer = customerEntityService.save(customer);
    return customer;
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable Long id) {
    Customer customer = customerEntityService.findByIdWithControl(id);

    return customer;
  }

  @GetMapping
  public List<Customer> findAllByNameAndSurname(@RequestParam String name, @RequestParam String surname){
    List<Customer> customerList = customerEntityService.findAllByNameAndSurname(name, surname);
    return customerList;
  }
}
