package com.system.Attendance.service;

import com.system.Attendance.config.ModellMapper;
import com.system.Attendance.domain.Event;
import com.system.Attendance.domain.Session;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.repository.SessionRepository;
import com.system.Attendance.service.contract.SessionPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionServiceImpl  implements SessionService{

    @Autowired
    EventRepository eventRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ModellMapper modellMapper;

    @Override
    public void addSession(Long eventId, List<SessionPayload> sessionPayload) {
        Optional<Event> event = eventRepository.findById(eventId);
        if(event.isPresent()){
            List<Session> sessionlist = new ArrayList<>();
            List<Session> sessionList = sessionPayload.stream().map(s -> modellMapper.modelMapper().map(s, Session.class)).collect(Collectors.toList());
            if(event.get().getSchedule().getSessions() == null){
                sessionlist.addAll(sessionList);
                event.get().getSchedule().setSessions(sessionList);
            } else {
                event.get().getSchedule().getSessions().addAll(sessionList);
            }
        }
        eventRepository.save(event.get());
    }
    @Override
    public List<Session> getAllSession(Long eventId){
        return eventRepository.findById(eventId).get().getSchedule().getSessions();
    }
    @Override
    public void deleteSession(Long eventId, Long sessionId){
        Optional<Event> event = eventRepository.findById(eventId);
        Optional<Session> session = event.get().getSchedule().getSessions()
                .stream().filter(s -> s.getId().equals(sessionId)).findAny();
        sessionRepository.deleteById(session.get().getId().intValue());
    }
    @Override
    public void updateSession(Long eventId, SessionPayload sessionPayload) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if(optionalEvent.isPresent()){
            Optional<Session> optionalSession = optionalEvent.get().getSchedule().getSessions().stream()
                    .filter(session -> session.getId().equals(sessionPayload.getId()))
                    .findFirst();
            if(optionalSession.isPresent()){
                optionalSession.get().setId(sessionPayload.getId());
                optionalSession.get().setStartTime(sessionPayload.getEndTime());
                optionalSession.get().setEndTime(sessionPayload.getEndTime());
                optionalSession.get().setMemberList(sessionPayload.getMemberList());
                optionalEvent.get().getSchedule().getSessions().add(optionalSession.get());
            }
            sessionRepository.save(optionalSession.get());
        }

    }
    @Override
    public Session getSession(Integer sessionId) {
        return sessionRepository.findById(sessionId).get();
    }

}
