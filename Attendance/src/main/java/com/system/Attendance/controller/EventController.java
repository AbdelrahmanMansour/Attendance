package com.system.Attendance.controller;

import com.system.Attendance.domain.Event;
import com.system.Attendance.domain.Session;
import com.system.Attendance.service.EventServiceImpl;
import com.system.Attendance.service.SessionServiceImpl;
import com.system.Attendance.service.contract.EventPayload;
import com.system.Attendance.service.contract.SessionPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController extends BaseReadWriteController<EventPayload, Event, Long>{

    @Autowired
    SessionServiceImpl sessionService;

    @Autowired
    EventServiceImpl eventService;
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

    @PostMapping("/{eventId}/addMembers")
    public ResponseEntity<?> addMembers(@PathVariable Long eventId, @RequestBody List<Integer> members){
        return new ResponseEntity<>(eventService.addMembersToEvent(eventId, members), HttpStatus.OK);
    }

    @GetMapping("/{eventId}/attendance")
    public ResponseEntity<?> calculateAttendance(@PathVariable Long eventId){
        return new ResponseEntity<>(
            eventService.calculateAttendance(eventId),
            HttpStatus.OK);
    }

}
