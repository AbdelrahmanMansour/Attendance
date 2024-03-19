package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Scanner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String scannerCode;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "account_id")
    private Account account;

    public Scanner() {
    }

    public Scanner(String scannerCode, Location location, Account account) {
        this.scannerCode = scannerCode;
        this.location = location;
        this.account = account;
    }

    public void setScannerCode(String scannerCode) {
        this.scannerCode = scannerCode;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
