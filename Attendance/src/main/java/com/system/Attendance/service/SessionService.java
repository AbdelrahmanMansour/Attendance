package com.system.Attendance.service;

import com.system.Attendance.domain.Member;

import com.system.Attendance.domain.Session;
import com.system.Attendance.service.contract.SessionPayload;
import edu.miu.common.service.BaseReadWriteService;

import java.util.List;


public interface SessionService {
   void addSession(Long eventId, List<SessionPayload> sessionPayload);
    List<Session> getAllSession(Long eventId);
    void deleteSession(Long eventId, Long sessionId);
    void updateSession(Long eventId, SessionPayload sessionPayload);
    Session getSession(Integer sessionId);
}
