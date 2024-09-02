package com.task.VacationCalculator.controller;

import com.task.VacationCalculator.model.VacationRequest;
import com.task.VacationCalculator.model.VacationResponse;
import com.task.VacationCalculator.service.VacationCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculate")
public class VacationController {
    private final VacationCalculatorService vacationCalculatorService;

    @PostMapping
    public ResponseEntity<VacationResponse> calculateVacation(@RequestBody VacationRequest request) {
        double vacationPay = vacationCalculatorService.calculateVacationPay(request);
        return ResponseEntity.ok(new VacationResponse(vacationPay));
    }
}