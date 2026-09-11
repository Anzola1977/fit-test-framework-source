package de.fit.framework.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
public class PositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private LocalDate serviceFrom;
    private LocalDate serviceTo;

    @ManyToOne(fetch = FetchType.LAZY)
    private HilfsmittelCaseEntity root;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private final List<TerminEntity> appointments = new ArrayList<>();

    protected PositionEntity() {
    }

    public PositionEntity(int number, LocalDate serviceFrom, LocalDate serviceTo) {
        this.number = number;
        this.serviceFrom = serviceFrom;
        this.serviceTo = serviceTo;
    }

    void attach(HilfsmittelCaseEntity root) {
        this.root = root;
    }

    public void add(TerminEntity appointment) {
        appointments.add(appointment);
        appointment.attach(this);
    }

    public int getNumber() { return number; }
    public LocalDate getServiceFrom() { return serviceFrom; }
    public LocalDate getServiceTo() { return serviceTo; }
    public List<TerminEntity> getAppointments() { return appointments; }
}
