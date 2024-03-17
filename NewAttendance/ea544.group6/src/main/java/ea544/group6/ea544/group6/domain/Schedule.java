package ea544.group6.ea544.group6.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.joda.time.DateTime;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monday")
    private Boolean monday;

    @Column(name = "tuesday")
    private Boolean tuesday;

    @Column(name = "wednesday")
    private Boolean wednesday;

    @Column(name = "thursday")
    private Boolean thursday;

    @Column(name = "friday")
    private Boolean friday;

    @Column(name = "saturday")
    private Boolean saturday;

    @Column(name = "sunday")
    private Boolean sunday;

    @Column(name = "start_time")
    private DateTime startTime;

    @Column(name = "end_time")
    private DateTime endTime;

    @OneToMany
    @JoinColumn(name = "schedule_id")
    private List<Session> sessions;


}
