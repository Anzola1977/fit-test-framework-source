package de.fit.framework.domain;
import de.fit.framework.api.Gender;import java.time.*;import java.util.*;
public record HilfsmittelCaseData(Long id,Gender gender,int age,LocalDate prescribedOn,boolean coPaymentExempt,List<PositionData> positions){public HilfsmittelCaseData{positions=List.copyOf(positions);}}
