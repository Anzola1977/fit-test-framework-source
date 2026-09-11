package de.fit.framework.persistence.entity;

import de.fit.framework.api.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hilfsmittel_case")
public class HilfsmittelCaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private LocalDate prescribedOn;
    private boolean coPaymentExempt;

    @OneToMany(mappedBy = "root", cascade = CascadeType.ALL)
    private final List<PositionEntity> positions = new ArrayList<>();

    protected HilfsmittelCaseEntity() {
    }

    public HilfsmittelCaseEntity(
            Gender gender,
            int age,
            LocalDate prescribedOn,
            boolean coPaymentExempt) {
        this.gender = gender;
        this.age = age;
        this.prescribedOn = prescribedOn;
        this.coPaymentExempt = coPaymentExempt;
    }

    public void add(PositionEntity position) {
        positions.add(position);
        position.attach(this);
    }

    public Long getId() { return id; }
    public Gender getGender() { return gender; }
    public int getAge() { return age; }
    public LocalDate getPrescribedOn() { return prescribedOn; }
    public boolean isCoPaymentExempt() { return coPaymentExempt; }
    public List<PositionEntity> getPositions() { return positions; }
}
