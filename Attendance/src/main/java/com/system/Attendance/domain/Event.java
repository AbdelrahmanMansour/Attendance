package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
    private String name;

    private String description;

    @ManyToOne
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Schedule schedule;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "event_member",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "member_id")})
    private List<Member> memberList = new ArrayList<Member>();

    public Event() {
    }

    public Event(String name, String description, Schedule schedule, Account account) {
        this.name = name;
        this.description = description;
        this.schedule = schedule;
        this.account = account;
    }


    public void setLocation(Location location) {
        this.location = location;
    }


    public void setAccount(Account account) {
        this.account = account;
    }

    public void addMember(Member member) {
        this.memberList.add(member);
    }


}
