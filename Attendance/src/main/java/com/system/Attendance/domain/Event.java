package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Schedule schedule;

    @ManyToMany(mappedBy = "eventList")
    private Set<Member> members = new HashSet<>();

    public Event() {
    }

    public Event(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesciption(String description) {
        this.description = description;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }
  
}
