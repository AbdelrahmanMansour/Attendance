package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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

    @OneToOne
    private Schedule schedule;

    @ManyToMany(mappedBy = "eventList")
    private List<Member> members;

}
