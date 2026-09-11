package de.fit.framework.api;
public record PositionRequest(int appointments,int durationMinutes){public PositionRequest{if(appointments<1)throw new IllegalArgumentException("appointments must be positive");if(durationMinutes<0)throw new IllegalArgumentException("duration must not be negative");}}
