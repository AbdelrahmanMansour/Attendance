package com.system.Attendance.service;

import com.system.Attendance.domain.Event;
import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Session;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.repository.SessionRepository;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.service.contract.EventPayload;
import com.system.Attendance.service.mapper.EventToEventPayloadMapper;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class EventServiceImpl extends BaseReadWriteServiceImpl<EventPayload, Event, Long> implements EventService{

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventToEventPayloadMapper eventToEventPayloadMapper;

    @Autowired
    MembersRepository membersRepository;

    @Autowired
    SessionRepository sessionRepository;

    public EventPayload addMembersToEvent(Long eventId, List<Integer> members) {
        Optional<Event> eventResponse = eventRepository.findById(eventId);
        if (eventResponse.isEmpty()){
            throw new EntityNotFoundException("No Event With ID: " + eventId);
        }
        List<Member> listMembers = membersRepository.findAllById(members);
        Event event = eventResponse.get();
        List<Member> eventMembers = event.getMemberList();
        eventMembers.addAll(listMembers);
        event.setMemberList(eventMembers);
        event = eventRepository.save(event);
        return eventToEventPayloadMapper.map(event);
    }

    public List<Session> calculateAttendance(Long eventId){
        return eventRepository.findSessionsByEventIdjpql(eventId);
    }

    @Override
    public int countAttendanceForEventByMember(Long memberId, Long eventId) {
        return eventRepository.countAttendanceForEventByMember(memberId, eventId);
    }
}
