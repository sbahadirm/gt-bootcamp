package com.garantitech.gtbootcamp.request;

import com.garantitech.gtbootcamp.enums.EnumStatus;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bahadirmemis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequestDTOClass {

  private String name;

  private String surname;

  private String username;

  private String password;

  private String email;

  private String phoneNumber;

  private LocalDate birthDate;

  private EnumStatus status;
}
