package com.garantitech.gtbootcamp.general;

import com.garantitech.gtbootcamp.exceptions.CustomerNotFoundException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author bahadirmemis
 */
@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler
  public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request){

    RestResponse<GenericErrorMessage>
        genericErrorMessageRestResponse = getGenericErrorMessageRestResponse(e, request);
    return new ResponseEntity<>(genericErrorMessageRestResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler
  public final ResponseEntity<Object> handleNoSuchElementExceptions(CustomerNotFoundException e, WebRequest request){
    RestResponse<GenericErrorMessage> genericErrorMessageRestResponse = getGenericErrorMessageRestResponse(e, request);
    return new ResponseEntity<>(genericErrorMessageRestResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public final ResponseEntity<Object> handleNoSuchElementExceptions(NoSuchElementException e, WebRequest request){
    RestResponse<GenericErrorMessage> genericErrorMessageRestResponse = getGenericErrorMessageRestResponse(e, request);
    return new ResponseEntity<>(genericErrorMessageRestResponse, HttpStatus.NOT_FOUND);
  }

  private RestResponse<GenericErrorMessage> getGenericErrorMessageRestResponse(Exception e, WebRequest request) {
    String message = e.getMessage();
    String description = request.getDescription(false);

    GenericErrorMessage genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
    RestResponse<GenericErrorMessage> genericErrorMessageRestResponse = RestResponse.error(genericErrorMessage);
    return genericErrorMessageRestResponse;
  }
}
