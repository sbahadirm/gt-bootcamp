package com.garantitech.gtbootcamp.contract;

import com.garantitech.gtbootcamp.dto.CustomerDTOClass;
import com.garantitech.gtbootcamp.entity.Customer;
import com.garantitech.gtbootcamp.request.CustomerSaveRequestDTOClass;

/**
 * @author bahadirmemis
 */
public interface CustomerControllerContract {

  Customer save(Customer customer);

  CustomerDTOClass save1(CustomerSaveRequestDTOClass customerSaveRequestDTO);
}
