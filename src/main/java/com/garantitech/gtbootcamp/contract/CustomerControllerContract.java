package com.garantitech.gtbootcamp.contract;

import com.garantitech.gtbootcamp.dto.CustomerDTO;
import com.garantitech.gtbootcamp.dto.CustomerDTOClass;
import com.garantitech.gtbootcamp.entity.Customer;
import com.garantitech.gtbootcamp.request.CustomerSaveRequestDTO;
import com.garantitech.gtbootcamp.request.CustomerSaveRequestDTOClass;

/**
 * @author bahadirmemis
 */
public interface CustomerControllerContract {

  Customer save2(Customer customer);

  CustomerDTOClass save1(CustomerSaveRequestDTOClass customerSaveRequestDTO);

  CustomerDTO save(CustomerSaveRequestDTO customerSaveRequestDTO);
}
