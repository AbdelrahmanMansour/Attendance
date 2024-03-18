package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Scanners implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sacannerCode;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "account_id")
    private Account account;

    public Scanners() {
    }

    public Scanners(String sacannerCode, Location location, Account account) {
        this.sacannerCode = sacannerCode;
        this.location = location;
        this.account = account;
    }

    public void setSacannerCode(String sacannerCode) {
        this.sacannerCode = sacannerCode;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
