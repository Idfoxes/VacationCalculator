package com.task.VacationCalculator.util;

import org.springframework.stereotype.Component;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

@Component
public class HolidayChecker {

    private static final Set<LocalDate> HOLIDAYS = Set.of(
            // Новый год
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 2),
            LocalDate.of(2024, 1, 3),
            LocalDate.of(2024, 1, 4),
            LocalDate.of(2024, 1, 5),
            LocalDate.of(2024, 1, 6),
            LocalDate.of(2024, 1, 8),

            // Рождество Христово
            LocalDate.of(2024, 1, 7),

            // День защитника Отечества
            LocalDate.of(2024, 2, 23),

            // Международный женский день
            LocalDate.of(2024, 3, 8),

            // Праздник Весны и Труда
            LocalDate.of(2024, 5, 1),

            // День Победы
            LocalDate.of(2024, 5, 9),

            // День России
            LocalDate.of(2024, 6, 12),

            // День народного единства
            LocalDate.of(2024, 11, 4),


            LocalDate.of(2024, 12, 25)
    );

    public boolean isHolidayOrWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                date.getDayOfWeek() == DayOfWeek.SUNDAY ||
                HOLIDAYS.contains(date);
    }
}