package com.garantitech.gtbootcamp.mapper;

import com.garantitech.gtbootcamp.dto.CustomerDTOClass;
import com.garantitech.gtbootcamp.entity.Customer;
import com.garantitech.gtbootcamp.request.CustomerSaveRequestDTOClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author bahadirmemis
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

  CustomerMapper INSTANCE  = Mappers.getMapper(CustomerMapper.class);

  //@Mapping(target = "email", source = "eposta")
  Customer convertToCustomer(CustomerSaveRequestDTOClass customerSaveRequestDTO);

  CustomerDTOClass convertToCustomerDTOClass(Customer customer);
}
