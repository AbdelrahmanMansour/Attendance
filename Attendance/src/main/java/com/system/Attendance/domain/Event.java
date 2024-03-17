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

    private String desciption;

    @ManyToOne
    private Schedule schedule;

    @ManyToOne
    private Location location;

    @ManyToMany(mappedBy = "eventList")
    private List<Member> members;

    @OneToOne
    private Account account;

}
