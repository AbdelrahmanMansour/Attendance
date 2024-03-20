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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;


   // added accountType
    private AccountType accountType;

    public Scanner() {
    }
    public Scanner(Location location) {
        this.location = location;
    }

}
