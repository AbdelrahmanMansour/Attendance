package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Session implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToMany(mappedBy = "sessionList")
    private List<Member> memberList;

    @ManyToOne
    private Schedule schedule;

}
