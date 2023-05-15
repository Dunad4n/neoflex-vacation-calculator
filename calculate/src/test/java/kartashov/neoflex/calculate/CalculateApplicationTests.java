package kartashov.neoflex.calculate;

import kartashov.neoflex.calculate.services.VacationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class CalculateApplicationTests {

	@Autowired
	private VacationService vacationService;

	@Test
	void getVacationPayTest() {
		//given
		BigDecimal averageSalary = new BigDecimal(50000);
		int numberOfVacationDay  = 14;
		BigDecimal expectedResponse = new BigDecimal(23884);

		//when
		BigDecimal response = vacationService.getVacationPay(averageSalary, numberOfVacationDay, null);

		//then
		Assertions.assertEquals(response.doubleValue(), expectedResponse.doubleValue(), 0.2);

		//given
		averageSalary = new BigDecimal(50000);
		numberOfVacationDay  = 21;
		expectedResponse = new BigDecimal(35826);

		//when
		response = vacationService.getVacationPay(averageSalary, numberOfVacationDay, null);

		//then
		Assertions.assertEquals(response.doubleValue(), expectedResponse.doubleValue(), 0.2);
	}

}
