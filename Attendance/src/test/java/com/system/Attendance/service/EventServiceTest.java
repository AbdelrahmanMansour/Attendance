package com.system.Attendance.service;

import com.system.Attendance.domain.Event;
import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Session;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.repository.SessionRepository;
import com.system.Attendance.service.mapper.EventToEventPayloadMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class EventServiceTest {

    private EventServiceImpl eventService;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private MembersRepository membersRepository;

    @Mock
    private EventToEventPayloadMapper eventToEventPayloadMapper;

    @Mock
    private SessionRepository sessionRepository;

    @BeforeEach
    public void setEventService(){
        eventService = new EventServiceImpl(
                eventRepository,
                eventToEventPayloadMapper,
                membersRepository,
                sessionRepository
        );
    }

    @Test
    public void testAddMembersToEvent() {
        Long eventId = 1L;
        List<Integer> members = Arrays.asList(1, 2, 3);

        Event event = new Event();
        event.setId(eventId);

        List<Member> memberList = Arrays.asList(new Member(), new Member(), new Member());

        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));
        when(membersRepository.findAllById(members)).thenReturn(memberList);

        eventService.addMembersToEvent(eventId, members);

        verify(eventRepository, times(1)).findById(eventId);
        verify(membersRepository, times(1)).findAllById(members);
        verify(eventRepository, times(1)).save(event);

        assertNotNull(event.getMemberList());
        assertEquals(event.getMemberList(), memberList);
    }

    @Test
    public void testCalculateAttendance() {
        Long eventId = 1L;
        List<Session> expectedSessions = Arrays.asList(new Session(), new Session());

        when(eventRepository.findSessionsByEventIdjpql(eventId)).thenReturn(expectedSessions);

        List<Session> result = eventService.calculateAttendance(eventId);

        verify(eventRepository, times(1)).findSessionsByEventIdjpql(eventId);
        assertEquals(expectedSessions.size(), result.size());
        assertEquals(expectedSessions, result);
    }

    @Test
    public void testCountEventsByMemberIdAndEventId() {

//        // Given
        Event event = new Event();
        event.setId(1L);
        Member member = new Member();
        member.setId(1L);

        mock(Event.class);
        mock(Member.class);
        mock(EventRepository.class);
        int expectedAttendanceCount = 3;
        when(eventRepository.countAttendanceForEventByMember(member.getId(), event.getId())).thenReturn(expectedAttendanceCount);

        // When
        int actualAttendanceCount = eventService.countAttendanceForEventByMember(member.getId(), event.getId());
//
//        // Then
        assertEquals(expectedAttendanceCount, actualAttendanceCount);
        verify(eventRepository).countAttendanceForEventByMember(member.getId(), event.getId());
    }

}
