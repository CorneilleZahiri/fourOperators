package com.quatreOperations.quatreOperations.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OperationRequest {
    @NotNull(message = "L'attribut operand1 est obligatoire")
    private Double operand1;

    @NotNull(message = "L'attribut operand2 est obligatoire")
    private Double operand2;

    @NotBlank(message = "L'attribut operator est obligatoire")
    private String operator;
}
