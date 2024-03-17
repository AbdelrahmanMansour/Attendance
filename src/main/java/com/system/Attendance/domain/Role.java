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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String desciption;

    @ManyToMany(mappedBy = "roles")
    private List<Member> memberList;

    @ManyToMany
    @JoinTable( name = "Account_Role",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "account_id")})
    private List<Account> accounts = new ArrayList<Account>();
}
