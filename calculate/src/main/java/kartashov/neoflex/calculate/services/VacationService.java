package kartashov.neoflex.calculate.services;

import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
@Data
public class VacationService {

    private final double AVERAGE_NUMBER_OF_DAYS_IN_MONTH = 29.3;

    public BigDecimal getVacationPay(BigDecimal averageSalary,
                                     int numberOfVacationDays,
                                     LocalDate firstVacationDay) {
        BigDecimal dividedSalary = averageSalary
                .divide(BigDecimal.valueOf(AVERAGE_NUMBER_OF_DAYS_IN_MONTH), RoundingMode.HALF_UP);

        if(firstVacationDay == null) {
            return dividedSalary
                    .multiply(BigDecimal.valueOf(numberOfVacationDays));
        }

        HolidayManager manager = HolidayManager.getInstance(HolidayCalendar.RUSSIA);
        numberOfVacationDays -= manager
                .getHolidays(firstVacationDay, firstVacationDay.plusDays(numberOfVacationDays))
                .size();

        return averageSalary
                .multiply(BigDecimal.valueOf(numberOfVacationDays));
    }

}
