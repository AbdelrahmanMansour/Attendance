package com.system.Attendance.controller;

import com.system.Attendance.domain.Event;
import com.system.Attendance.service.contract.EventPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController extends BaseReadWriteController<EventPayload, Event, Long>{
}
