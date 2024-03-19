package com.system.Attendance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String description;

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
