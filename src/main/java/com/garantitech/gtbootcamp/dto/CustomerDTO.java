package com.garantitech.gtbootcamp.dto;

import com.garantitech.gtbootcamp.enums.EnumStatus;
import java.time.LocalDate;

/**
 * @author bahadirmemis
 */
public record CustomerDTO(Long id,
                          String name,
                          String surname,
                          String username,
                          String email,
                          String phoneNumber,
                          LocalDate birthDate,
                          EnumStatus status) {

}
