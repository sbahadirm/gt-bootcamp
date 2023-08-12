package com.garantitech.gtbootcamp.general;

import java.time.LocalDateTime;

/**
 * @author bahadirmemis
 */
public record GenericErrorMessage(LocalDateTime date, String message, String description) {

}
