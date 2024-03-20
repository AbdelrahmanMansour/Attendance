package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Session implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String startTime;
    private String endTime;
    @ManyToMany(mappedBy = "sessions")
    private List<Member> memberList = new ArrayList<Member>();
    @ManyToOne
    @JoinColumn(name = "scanner_id")
    private Scanner scanner;
    public Session() {
    }
    public Session(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public void addMember(Member member) {
        this.memberList.add(member);
    }

}
