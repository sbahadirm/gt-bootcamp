package com.garantitech.gtbootcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author bahadirmemis
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends BusinessException{

  public CustomerNotFoundException(BaseErrorMessage baseErrorMessage) {
    super(baseErrorMessage);
  }
}
