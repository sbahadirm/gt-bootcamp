package com.garantitech.gtbootcamp.exceptions;

/**
 * @author bahadirmemis
 */
public enum CustomerErrorMessages implements BaseErrorMessage{

  NOT_FOUND("Customer not found!"),
  CUSTOMER_ALREADY_PASSIVE("Customer is already passive!"),
  PASSWORDS_DOES_NOT_MATCH("Given passwords are different!"),
  WRONG_OLD_PASSWORD("Old password is wrong!"),
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
