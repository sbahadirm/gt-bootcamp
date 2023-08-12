package com.garantitech.gtbootcamp.controller;

import com.garantitech.gtbootcamp.contract.CustomerControllerContract;
import com.garantitech.gtbootcamp.dto.CustomerDTO;
import com.garantitech.gtbootcamp.general.RestResponse;
import com.garantitech.gtbootcamp.request.CustomerSaveRequestDTO;
import com.garantitech.gtbootcamp.request.CustomerUpdateRequestDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public ResponseEntity<RestResponse<CustomerDTO>> save(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO) {
    CustomerDTO customerDTO = contract.save(customerSaveRequestDTO);
    return new ResponseEntity<>(RestResponse.of(customerDTO), HttpStatus.CREATED);
  }

  //@PostMapping
  //public ResponseEntity<RestResponse<CustomerDTO>> save2(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO) {
  //  CustomerDTO customerDTO = contract.save(customerSaveRequestDTO);
  //  return ResponseEntity.ok(RestResponse.of(customerDTO));
  //}

  @GetMapping
  public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll() {
    List<CustomerDTO> customerDTOList = contract.findAll();
    return ResponseEntity.ok(RestResponse.of(customerDTOList));
  }

  @GetMapping("/{id}")
  public ResponseEntity<RestResponse<CustomerDTO>> findById(@PathVariable Long id) {
    CustomerDTO customerDTO = contract.findById(id);
    return ResponseEntity.ok(RestResponse.of(customerDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<RestResponse<CustomerDTO>> update(@PathVariable Long id,
                                                          @RequestBody CustomerUpdateRequestDTO dto) {
    CustomerDTO customerDTO = contract.update(dto);
    return ResponseEntity.ok(RestResponse.of(customerDTO));
  }

  @PatchMapping("/{id}/deactivate")
  public ResponseEntity<RestResponse<CustomerDTO>> deactivate(@PathVariable Long id){
    CustomerDTO customerDTO = contract.deactivate(id);
    return ResponseEntity.ok(RestResponse.of(customerDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id){
    contract.delete(id);
    return ResponseEntity.ok(RestResponse.empty());
  }
}
