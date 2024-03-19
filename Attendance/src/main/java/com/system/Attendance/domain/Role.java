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

    @ManyToMany(mappedBy = "roles")
    private List<Member> memberList = new ArrayList<Member>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable( name = "Account_Role",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "account_id")})
    private List<Account> accounts = new ArrayList<Account>();

    public Role() {
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesciption(String description) {
        this.description = description;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void addMember(Member member) {
        this.memberList.add(member);
    }

}
