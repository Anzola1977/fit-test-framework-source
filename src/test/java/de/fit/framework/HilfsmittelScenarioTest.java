package de.fit.framework;

import de.fit.framework.api.Gender;
import de.fit.framework.api.HilfsmittelScenario;
import de.fit.framework.service.HilfsmittelTestDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HilfsmittelScenarioTest {

    @Autowired
    private HilfsmittelTestDataService service;

    @Test
    void createsTwoPositionsAndSixteenAppointments() {
        HilfsmittelScenario scenario = HilfsmittelScenario.builder()
                .gender(Gender.MALE)
                .age(57)
                .prescribedOn(LocalDate.of(2022, 9, 16))
                .coPaymentExempt(true)
                .addPosition(10, 30)
                .addPosition(6, 20)
                .build();

        Long id = service.create(scenario);
        var actual = service.read(id);

        assertThat(actual.positions()).hasSize(2);
        assertThat(actual.positions().get(0).appointments()).hasSize(10);
        assertThat(actual.positions().get(1).appointments()).hasSize(6);
        assertThat(actual.positions().get(0).appointments().get(0).startsAt())
                .isEqualTo(LocalDateTime.of(2022, 9, 16, 9, 0));
    }
}
