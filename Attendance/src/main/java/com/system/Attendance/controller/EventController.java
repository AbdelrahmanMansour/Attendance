package com.system.Attendance.controller;

import com.system.Attendance.domain.Event;
import com.system.Attendance.domain.Session;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.service.SessionServiceImpl;
import com.system.Attendance.service.contract.EventPayload;
import com.system.Attendance.service.contract.SessionPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController extends BaseReadWriteController<EventPayload, Event, Long>{

    @Autowired
    SessionServiceImpl sessionService;
    @PostMapping("/{eventId}/sessions")
    public void addSession(@PathVariable Long eventId, @RequestBody List<SessionPayload> sessionPayloadList){
        sessionService.addSession(eventId, sessionPayloadList);
    }
    @GetMapping("/{eventId}/sessions")
    public List<Session> getSession(@PathVariable Long eventId){
        return  sessionService.getSession(eventId);
    }
    @DeleteMapping("/{eventId}/sessions/{sessionId}")
    public void deleteSession(@PathVariable Long eventId, @PathVariable Long sessionId){
          sessionService.deleteSession(eventId, sessionId);
    }

    @PutMapping("/{eventId}/sessions")
    public void updateSession(@PathVariable Long eventId, @RequestBody SessionPayload sessionPayload){
        sessionService.updateSession(eventId, sessionPayload);
    }

}
