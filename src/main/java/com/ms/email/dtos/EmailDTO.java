package com.ms.email.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
public record EmailDTO(
        @NotBlank
        String ownerRef,
        @NotBlank
        @Email
        String emailFrom,
        @NotBlank
        @Email
        String emailTo,
        @NotBlank
        String subject,
        @NotBlank
        String text
) {

}
