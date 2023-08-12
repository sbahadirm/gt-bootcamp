package com.garantitech.gtbootcamp.controller;

import com.garantitech.gtbootcamp.contract.CustomerControllerContract;
import com.garantitech.gtbootcamp.dto.CustomerDTO;
import com.garantitech.gtbootcamp.request.CustomerSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerControllerContract contract;

  //@PostMapping
  //public CustomerDTOClass save1(@RequestBody CustomerSaveRequestDTOClass customerSaveRequestDTO) {
  //  CustomerDTOClass customerDTO = contract.save1(customerSaveRequestDTO);
  //  return customerDTO;
  //}

  @PostMapping
  public ResponseEntity<CustomerDTO> save(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO) {
    CustomerDTO customerDTO = contract.save(customerSaveRequestDTO);
    return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
  }
}
