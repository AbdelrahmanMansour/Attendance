package com.system.Attendance.repository;


import com.system.Attendance.domain.Event;
import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Schedule;
import com.system.Attendance.domain.Session;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@DataJpaTest
class EventRepositoryTest {

    @Mock
    private EventRepository eventRepository;

    @Test
    public void testCountEventsByMemberIdAndEventId() {

        Event event = new Event();
        event.setId(2L);
        Member member = new Member();
        member.setId(1L);

        when(eventRepository.countAttendanceForEventByMember(member.getId(), event.getId())).thenReturn(3);

        // Execute the query using the repository
        int count = eventRepository.countAttendanceForEventByMember(1L, 2L);

        // Assert the result
        assertEquals(3, count);
    }
//
//    @Autowired
//    private ScheduleRepository scheduleRepository;
//
//    @Autowired SessionRepository sessionRepository;
//
//    @Test
//    @Transactional
//    public void testFindSessionsByEventIdjpql() {
//        // Arrange
//        Event event = new Event();
//        eventRepository.save(event);
//        Schedule schedule = new Schedule();
//
//        schedule = scheduleRepository.save(schedule);
//
//        Session session1 = new Session();
//        Session session2 = new Session();
//
//        sessionRepository.saveAll(List.of(session2, session1));
//
//        schedule.addSession(session1);
//        schedule.addSession(session2);
//
//        scheduleRepository.save(schedule);
//        scheduleRepository.flush();
//
//        event.setSchedule(schedule);
//
//        eventRepository.save(event);
//        eventRepository.flush();
//        entityManager.flush();
//
//        // Act
//        List<Session> sessions = eventRepository.findSessionsByEventIdjpql(event.getId());
//
//        // Assert
//        assertNotNull(sessions);
//        assertEquals(2, sessions.size());
//    }
}
