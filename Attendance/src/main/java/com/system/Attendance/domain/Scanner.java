package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Scanner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "scanner_id")
    private List<Session> session;

    public Scanner() {
    }
    public Scanner(Location location) {
        this.location = location;
    }

}
