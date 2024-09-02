package com.task.VacationCalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacationRequest {
    private double averageSalary;
    private int vacationDays;
    private List<LocalDate> vacationDates;
}