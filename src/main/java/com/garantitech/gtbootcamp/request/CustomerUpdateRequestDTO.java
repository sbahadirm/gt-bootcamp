package com.garantitech.gtbootcamp.request;

import java.time.LocalDate;

/**
 * @author bahadirmemis
 */
public record CustomerUpdateRequestDTO(Long id,
                                       String name,

                                       String surname,

                                       String username,

                                       String email,

                                       String phoneNumber,

                                       LocalDate birthDate) {

}
