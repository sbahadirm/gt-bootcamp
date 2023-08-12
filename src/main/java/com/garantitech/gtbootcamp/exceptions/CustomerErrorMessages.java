package com.garantitech.gtbootcamp.exceptions;

/**
 * @author bahadirmemis
 */
public enum CustomerErrorMessages implements BaseErrorMessage{

  NOT_FOUND("Customer not found!"),
  CUSTOMER_ALREADY_PASSIVE("Customer is already passive!")
  ;

  private String message;

  CustomerErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return message;
  }
}
