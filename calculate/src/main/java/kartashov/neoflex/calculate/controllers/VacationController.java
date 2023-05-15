package kartashov.neoflex.calculate.controllers;

import kartashov.neoflex.calculate.services.VacationService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class VacationController {

    private final VacationService vacationService;

    @GetMapping("/calculate")
    public BigDecimal getVacationPay(@RequestParam(name = "avgSalary") @NonNull BigDecimal averageSalary,
                                     @RequestParam(name = "numberOfDays") int numberOfVacationDays,
                                     @RequestParam(name = "firstDay") @Nullable LocalDate firstVacationDay) {
        return vacationService.getVacationPay(averageSalary, numberOfVacationDays, firstVacationDay);
    }

}
