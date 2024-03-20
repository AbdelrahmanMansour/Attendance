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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String day;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private List<Session> sessions = new ArrayList<Session>();
    public Schedule() {
    }

    public Schedule(String day) {
        this.day = day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public void addSession(Session session) {
        this.sessions.add(session);
    }

}
