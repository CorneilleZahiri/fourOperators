package com.quatreOperations.quatreOperations.controller;

import com.quatreOperations.quatreOperations.dto.OperationRequest;
import com.quatreOperations.quatreOperations.dto.OperationResponse;
import com.quatreOperations.quatreOperations.service.OperationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.InvalidPropertiesFormatException;

@RestController
@RequestMapping("/operation")
@AllArgsConstructor
public class OperationsController {
    private final OperationService operationService;

    @PostMapping
    public ResponseEntity<OperationResponse> operation(
            @Valid @RequestBody OperationRequest request
    ) throws InvalidPropertiesFormatException {

        return ResponseEntity.ok().body(operationService.operations(request));
    }

}
