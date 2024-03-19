package com.system.Attendance.domain;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @ManyToOne
    private Scanner scanner;

    @ManyToMany(mappedBy = "accounts", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Role> roles = new ArrayList<>();
    public Account() {
    }

    public Account(String name, String description, AccountType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

}
