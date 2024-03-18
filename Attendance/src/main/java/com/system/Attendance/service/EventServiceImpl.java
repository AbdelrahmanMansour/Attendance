package com.system.Attendance.service;

import com.system.Attendance.domain.Event;
import com.system.Attendance.service.contract.EventPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl extends BaseReadWriteServiceImpl<EventPayload, Event, Long> implements EventService{
}
