package com.system.Attendance.domain;

import com.system.Attendance.enums.AccountType;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Scanner scanner;
    public Account() {
    }

    public Account(String name, String description, AccountType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

}
