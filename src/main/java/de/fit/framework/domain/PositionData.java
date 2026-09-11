package de.fit.framework.domain;

import java.time.LocalDate;
import java.util.List;

public record PositionData(
        int number,
        LocalDate serviceFrom,
        LocalDate serviceTo,
        List<TerminData> appointments) {

    public PositionData {
        appointments = List.copyOf(appointments);
    }
}
