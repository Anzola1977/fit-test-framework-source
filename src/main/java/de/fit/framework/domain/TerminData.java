package de.fit.framework.domain;
import java.time.LocalDateTime;
public record TerminData(int sequence,LocalDateTime startsAt,LocalDateTime endsAt,int durationMinutes){}
