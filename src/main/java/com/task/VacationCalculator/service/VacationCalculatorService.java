package com.task.VacationCalculator.service;

import com.task.VacationCalculator.model.VacationRequest;
import com.task.VacationCalculator.util.HolidayChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacationCalculatorService {
    private final HolidayChecker holidayChecker;

    public double calculateVacationPay(VacationRequest request){
        double dailyRate = request.getAverageSalary() / 29.3;
        int actualVacationDays = request.getVacationDays();

        if(request.getVacationDates() != null && !request.getVacationDates().isEmpty()){
            actualVacationDays = (int) request.getVacationDates().stream()
                    .filter(date -> !holidayChecker.isHolidayOrWeekend(date))
                    .count();
        }
        return dailyRate * actualVacationDays;
    }
}