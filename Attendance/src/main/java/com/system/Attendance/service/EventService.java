package com.system.Attendance.service;

import com.system.Attendance.domain.Event;
import com.system.Attendance.service.contract.EventPayload;
import edu.miu.common.service.BaseReadWriteService;

public interface EventService extends BaseReadWriteService<EventPayload, Event, Long> {
    int countAttendanceForEventByMember(Long memberId, Long eventId);
}
