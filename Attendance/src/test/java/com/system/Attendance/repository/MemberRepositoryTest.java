package com.system.Attendance.repository;

import com.system.Attendance.domain.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private SessionRepository sessionRepository;

    Member member;
    Event event;
    Schedule schedule;
    Session session;

    @BeforeEach
    void setUp() {
        member = new Member("DeoM","Deo","Mugabe","1234",1000.0,"deo@gmail.com");
        memberRepository.save(member);
        event =

    }

//    @Query("SELECT COUNT(DISTINCT s.id) " +
//            "FROM Member m " +
//            "JOIN m.eventList e " +
//            "JOIN e.schedule sch " +
//            "JOIN sch.sessions s " +
//            "LEFT JOIN s.memberList sm " +
//            "WHERE m.id = :memberId " +
//            "AND e.id = :eventId")
//private String name;
//
//    private String description;
//
//    @ManyToOne
//    private Location location;
//
//    @ManyToOne
//    private Account account;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Schedule schedule;
//
//    @ManyToMany(mappedBy = "eventList")
//    private Set<Member> members = new HashSet<>();
    @AfterEach
    void tearDown() {
        member = null;
        repository.deleteAll();
    }

    @Test
    void countAttendanceByMemberIdAndEventId() {
    }
}