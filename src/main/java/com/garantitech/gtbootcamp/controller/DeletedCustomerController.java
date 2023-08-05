package com.garantitech.gtbootcamp.controller;

import com.garantitech.gtbootcamp.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author bahadirmemis
 */
//@RestController
@RequestMapping("/api/v1/customers")
public class DeletedCustomerController {

  @GetMapping("/all")
  public List<Customer> getAllCustomers(){
    Customer bahadir = new Customer();
    bahadir.setName("bahadir");
    bahadir.setSurname("memis");

    Customer nurevsan = new Customer();
    nurevsan.setName("Nurevsan");
    nurevsan.setSurname("Kurak");

    List<Customer> customerList = new ArrayList<>();
    customerList.add(bahadir);
    customerList.add(nurevsan);

    return customerList;
  }

  @PostMapping("")
  public Customer save(@RequestBody Customer customer){
    System.out.println("customer saved!");
    return customer;
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable Long id){
    Customer customer = new Customer();
    customer.setId(id);
    customer.setName("Melisa");
    customer.setSurname("Çevik");

    return customer;
  }

  /**
   * GET ALL CUSTOMERS          -> localhost:8080/customers
   * GET A CUSTOMER             -> localhost:8080/customers/1
   * GET ALL CUSTOMERS BY NANE  -> localhost:8080/customers?name=bahadir&surname=memis (request param)
   * @param name
   * @return
   */
  @GetMapping("")
  public List<Customer> getAllCustomersByName(@RequestParam String name,
                                              @RequestParam(required = false) String surname){

    List<Customer> customerList = new ArrayList<>();
    Customer customer1 = new Customer();
    customer1.setName(name);
    customer1.setSurname(surname);

    Customer customer2 = new Customer();
    customer2.setName(name);
    customer2.setSurname(surname);

    customerList.add(customer1);
    customerList.add(customer2);
    return customerList;
  }

  @DeleteMapping("/{id}")
  public void deleteCustomerById(@PathVariable Long id){
    System.out.println("customer is deleted. id: " + id);
  }
}
