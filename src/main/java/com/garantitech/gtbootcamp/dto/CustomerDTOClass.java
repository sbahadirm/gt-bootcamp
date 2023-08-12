package com.garantitech.gtbootcamp.dto;

import com.garantitech.gtbootcamp.enums.EnumStatus;
import java.time.LocalDate;
import lombok.Data;

/**
 * @author bahadirmemis
 */
@Data
public class CustomerDTOClass {

  private Long id;
  private String name;
  private String surname;
  private String username;
  private String email;
  private String phoneNumber;
  private LocalDate birthDate;
  private EnumStatus status;
}
