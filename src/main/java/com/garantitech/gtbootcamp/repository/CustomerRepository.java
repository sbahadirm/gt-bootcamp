package com.garantitech.gtbootcamp.repository;

import com.garantitech.gtbootcamp.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author bahadirmemis
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  List<Customer> findAllByNameAndSurname(String name, String surname);

  @Query("select c from Customer c where c.name = :name and c.surname = :surname")
  List<Customer> findAllByNameAndSurnameWithQuery(String name, String surname);
}
