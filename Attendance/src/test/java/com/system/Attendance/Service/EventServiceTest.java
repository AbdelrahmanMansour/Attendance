package com.system.Attendance.Service;

import com.system.Attendance.domain.Event;
import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Session;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.repository.SessionRepository;
import com.system.Attendance.service.EventServiceImpl;
import com.system.Attendance.service.contract.EventPayload;
import com.system.Attendance.service.mapper.EventToEventPayloadMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class EventServiceTest {

    @Autowired
    private EventServiceImpl eventService;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private MembersRepository membersRepository;

    @Mock
    private SessionRepository sessionRepository;

    @BeforeEach
    public void setEventService(){
        eventService = new EventServiceImpl(
                eventRepository,
                new EventToEventPayloadMapper(),
                membersRepository,
                sessionRepository

        );
    }

    @Test
    public void testAddMembersToEvent() {
        // Arrange
        Long eventId = 1L;
        List<Integer> members = Arrays.asList(1, 2, 3);

        Event event = new Event();
        event.setId(eventId);

        List<Member> memberList = Arrays.asList(new Member(), new Member(), new Member());

        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));
        when(membersRepository.findAllById(members)).thenReturn(memberList);

        // Act
        EventPayload result = eventService.addMembersToEvent(eventId, members);

        // Assert
        verify(eventRepository, times(1)).findById(eventId);
        verify(membersRepository, times(1)).findAllById(members);
        verify(eventRepository, times(1)).save(event);

        assertNotNull(result);
        // Add more assertions as needed based on your implementation
    }

    @Test
    public void testCalculateAttendance() {
        // Arrange
        Long eventId = 1L;
        List<Session> expectedSessions = Arrays.asList(new Session(), new Session());

        when(eventRepository.findSessionsByEventIdjpql(eventId)).thenReturn(expectedSessions);

        // Act
        List<Session> result = eventService.calculateAttendance(eventId);

        // Assert
        verify(eventRepository, times(1)).findSessionsByEventIdjpql(eventId);
        assertEquals(expectedSessions.size(), result.size());
        assertEquals(expectedSessions, result);
    }

}
