package com.system.Attendance.service;

import com.system.Attendance.domain.Event;
import com.system.Attendance.domain.Member;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.service.contract.EventPayload;
import com.system.Attendance.service.mapper.EventToEventPayloadMapper;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EventServiceImpl extends BaseReadWriteServiceImpl<EventPayload, Event, Long> implements EventService{

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventToEventPayloadMapper eventToEventPayloadMapper;

    @Autowired
    MembersRepository membersRepository;

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
}
