package com.system.Attendance.service;

import com.system.Attendance.DTO.SessionMapper;
import com.system.Attendance.domain.Event;
import com.system.Attendance.domain.Session;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.service.contract.SessionPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.system.Attendance.DTO.SessionMapper.MAPPER;

@Service
public class SessionServiceImpl  {

    @Autowired
    EventRepository eventRepository;

    public void addSession(Long eventId, SessionPayload sessionPayload) {
        Optional<Event> event = eventRepository.findById(eventId);
        List<Session> sessions = new ArrayList<>();
        sessions.add(MAPPER.toEntity(sessionPayload));
        event.get().getSchedule().setSessions(sessions);
        eventRepository.save(event.get());
    }

    public List<Session> getSession(Long eventId){
        return eventRepository.findById(eventId).get().getSchedule().getSessions();
    }

    public void deleteSession(Long eventId){
         eventRepository.deleteById(eventId);
    }

    public void updateSession(Long eventId, SessionPayload sessionPayload) {
        Optional<Event> event = eventRepository.findById(eventId);
        List<Session> sessions = new ArrayList<>();
        sessions.add(MAPPER.toEntity(sessionPayload));
        boolean sessionsFound = event.get().getSchedule().getSessions().contains(sessionPayload);
        event.get().getSchedule().setSessions(sessions);
        eventRepository.save(event.get());
    }
	
}
