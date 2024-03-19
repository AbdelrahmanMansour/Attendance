package com.system.Attendance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.system.Attendance.enums.AccountType;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Scanner scanner;

    @ManyToMany( cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Role> roles = new ArrayList<>();
    public Account() {
    }

    public Account(String name, String description, AccountType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

}
