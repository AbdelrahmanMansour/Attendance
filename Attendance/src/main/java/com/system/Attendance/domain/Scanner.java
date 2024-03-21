package com.system.Attendance.domain;

import com.system.Attendance.enums.AccountType;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Scanner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String scannerCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "session_id")
    private List<Session> sessions;

   // added accountType
    private AccountType accountType;

    public Scanner() {
    }
    public Scanner(Location location) {
        this.location = location;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public void addSession(Session session) {
        this.sessions.add(session);
    }


}
