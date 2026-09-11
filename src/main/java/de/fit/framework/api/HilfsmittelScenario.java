package de.fit.framework.api;
import java.time.LocalDate;import java.util.*;
public record HilfsmittelScenario(Gender gender,int age,LocalDate prescribedOn,boolean coPaymentExempt,List<PositionRequest> positions){
 public HilfsmittelScenario{Objects.requireNonNull(gender);Objects.requireNonNull(prescribedOn);positions=List.copyOf(positions);if(age<0||age>120)throw new IllegalArgumentException("age must be 0..120");if(positions.isEmpty())throw new IllegalArgumentException("position required");}
 public static Builder builder(){return new Builder();}
 public static final class Builder{private Gender gender=Gender.FEMALE;private int age=40;private LocalDate date=LocalDate.now();private boolean exempt;private final List<PositionRequest> positions=new ArrayList<>();public Builder gender(Gender v){gender=v;return this;}public Builder age(int v){age=v;return this;}public Builder prescribedOn(LocalDate v){date=v;return this;}public Builder coPaymentExempt(boolean v){exempt=v;return this;}public Builder addPosition(int count,int minutes){positions.add(new PositionRequest(count,minutes));return this;}public HilfsmittelScenario build(){return new HilfsmittelScenario(gender,age,date,exempt,positions);}}
}
