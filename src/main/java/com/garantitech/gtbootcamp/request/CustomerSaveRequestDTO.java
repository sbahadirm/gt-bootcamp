package com.garantitech.gtbootcamp.request;

import com.garantitech.gtbootcamp.enums.EnumStatus;
import java.time.LocalDate;

/**
 * @author bahadirmemis
 */
public record CustomerSaveRequestDTO(String name,

                                     String surname,

                                     String username,

                                     String password,

                                     String email,

                                     String phoneNumber,

                                     LocalDate birthDate,

                                     EnumStatus status) {

}
