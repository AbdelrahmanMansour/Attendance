package com.system.Attendance.service;

import com.system.Attendance.DTO.SessionMapper;
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

import static com.system.Attendance.DTO.SessionMapper.MAPPER;

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
            if(event.get().getSchedule().getSessions() == null){
                sessionlist.addAll(sessionPayload.stream().map(s -> MAPPER.toEntity(s)).collect(Collectors.toList()));
                event.get().getSchedule().setSessions(sessionlist);
            } else {
                event.get().getSchedule().getSessions().addAll(sessionPayload.stream().map(s -> modellMapper.modelMapper().map(s, Session.class)).collect(Collectors.toList()));
            }
        }
        eventRepository.save(event.get());
    }
    @Override
    public List<Session> getSession(Long eventId){
        return eventRepository.findById(eventId).get().getSchedule().getSessions();
    }
    @Override
    public void deleteSession(Long eventId, Long sessionId){
        Optional<Event> event = eventRepository.findById(eventId);
        Optional<Session> x = event.get().getSchedule().getSessions()
                .stream().filter(s -> s.getId().equals(sessionId)).findFirst();
        sessionRepository.delete(x.get());
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
        }
        eventRepository.save(optionalEvent.get());
    }

}
