package com.garantitech.gtbootcamp.request;

/**
 * @author bahadirmemis
 */
public record CustomerChangePasswordRequestDTO(String oldPassword, String newPassword, String newPasswordAgaing) {

}
