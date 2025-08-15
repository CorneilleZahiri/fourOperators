package com.quatreOperations.quatreOperations.service;

import com.quatreOperations.quatreOperations.dto.OperationRequest;
import com.quatreOperations.quatreOperations.dto.OperationResponse;
import org.springframework.stereotype.Service;

import java.util.InvalidPropertiesFormatException;
import java.util.Set;

@Service
public class OperationService {
    public OperationResponse operations(OperationRequest request) throws InvalidPropertiesFormatException {
        // Contrôler l'opérateur
        controlCharacter(request.getOperator());

        if ((request.getOperator().equals("/") && request.getOperand2() == 0)) {
            throw new InvalidPropertiesFormatException("Division par zéro non autorisée.");
        }

        double result = 0.0;

        switch (request.getOperator()) {
            case "+":
                result = request.getOperand1() + request.getOperand2();
                break;
            case "-":
                result = request.getOperand1() - request.getOperand2();
                break;
            case "*":
                result = request.getOperand1() * request.getOperand2();
                break;
            case "/":
                result = request.getOperand1() / request.getOperand2();
                break;

            default:
        }

        return new OperationResponse(result);
    }

    private void controlCharacter(String operator) throws InvalidPropertiesFormatException {
        if (!Set.of("+", "-", "*", "/").contains(operator)) {
            throw new InvalidPropertiesFormatException("L'opérateur doit appartenir à [ + ; - ; * ; / ]");
        }
    }
}
