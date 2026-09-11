package de.fit.framework.generation;

import de.fit.framework.api.HilfsmittelScenario;
import de.fit.framework.api.PositionRequest;
import de.fit.framework.domain.HilfsmittelCaseData;
import de.fit.framework.domain.PositionData;
import de.fit.framework.domain.TerminData;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class HilfsmittelGenerator {

    public HilfsmittelCaseData generate(HilfsmittelScenario scenario) {
        List<PositionData> positions = new ArrayList<>();
        int positionNumber = 1;

        for (PositionRequest request : scenario.positions()) {
            List<TerminData> appointments = generateAppointments(scenario, request);
            positions.add(new PositionData(
                    positionNumber++,
                    appointments.get(0).startsAt().toLocalDate(),
                    appointments.get(appointments.size() - 1).endsAt().toLocalDate(),
                    appointments));
        }

        return new HilfsmittelCaseData(
                null,
                scenario.gender(),
                scenario.age(),
                scenario.prescribedOn(),
                scenario.coPaymentExempt(),
                positions);
    }

    private List<TerminData> generateAppointments(
            HilfsmittelScenario scenario,
            PositionRequest request) {
        List<TerminData> appointments = new ArrayList<>();
        LocalDateTime firstAppointment = scenario.prescribedOn().atTime(9, 0);

        for (int index = 0; index < request.appointments(); index++) {
            LocalDateTime startsAt = firstAppointment.plusDays(index);
            appointments.add(new TerminData(
                    index + 1,
                    startsAt,
                    startsAt.plusMinutes(request.durationMinutes()),
                    request.durationMinutes()));
        }
        return appointments;
    }
}
