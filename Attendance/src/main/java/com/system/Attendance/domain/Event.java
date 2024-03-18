package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String desciption;

    @ManyToOne
    private Schedule schedule;

    @ManyToOne
    private Location location;

    @ManyToMany(mappedBy = "eventList")
    private List<Member> members = new ArrayList<Member>();

    @OneToOne
    private Account account;

    public Event() {
    }

    public Event(String name, String desciption) {
        this.name = name;
        this.desciption = desciption;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }
}
