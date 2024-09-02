package com.task.VacationCalculator;

import com.task.VacationCalculator.model.VacationRequest;
import com.task.VacationCalculator.service.VacationCalculatorService;
import com.task.VacationCalculator.util.HolidayChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacationCalculatorServiceTest {
    private VacationCalculatorService vacationCalculatorService;
    private HolidayChecker holidayChecker;
    private static final double DELTA = 1e-2;

    @BeforeEach
    public void setUp() {
        holidayChecker = new HolidayChecker();
        vacationCalculatorService = new VacationCalculatorService(holidayChecker);
    }

    @Test
    public void calculateVacationPayWithoutHolidays() {
        double averageSalary = 60000.0;
        int vacationDays = 28;

        VacationRequest request = new VacationRequest(averageSalary, vacationDays, null);

        double actual = vacationCalculatorService.calculateVacationPay(request);

        double expected = (60000.0 / 29.3) * vacationDays;

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculateVacationPayWithHolidays() {
        double averageSalary = 60000.0;
        int vacationDays = 28;

        List<LocalDate> vacationDates = List.of(
                LocalDate.of(2024, 1, 2),
                LocalDate.of(2024, 1, 3),
                LocalDate.of(2024, 1, 4),
                LocalDate.of(2024, 1, 5),
                LocalDate.of(2024, 1, 6),
                LocalDate.of(2024, 1, 8),
                LocalDate.of(2024, 1, 9),
                LocalDate.of(2024, 1, 10),
                LocalDate.of(2024, 1, 11),
                LocalDate.of(2024, 1, 12),
                LocalDate.of(2024, 1, 15)
        );

        VacationRequest request = new VacationRequest(averageSalary, vacationDays, vacationDates);

        double actual = vacationCalculatorService.calculateVacationPay(request);

        int expectedVacationDays = (int) vacationDates.stream()
                .filter(date -> !holidayChecker.isHolidayOrWeekend(date))
                .count();

        double expected = (averageSalary / 29.3) * expectedVacationDays;

        assertEquals(expected, actual, DELTA);
    }
}