package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "role_account",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "account_id")})
    private List<Account> accounts = new ArrayList<>();

    public Role() {
    }

    public Role(String name, String desciption) {
        this.name = name;
        this.description = desciption;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesciption(String desciption) {
        this.description = desciption;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }


}
