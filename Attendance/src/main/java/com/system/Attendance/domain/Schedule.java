package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate day;

    @OneToMany
    @JoinColumn(name = "schedule_id")
    private List<Session> sessions = new ArrayList<Session>();
    public Schedule() {
    }

    public Schedule(LocalDate day) {
        this.day = day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public void addSession(Session session) {
        this.sessions.add(session);
    }

}
