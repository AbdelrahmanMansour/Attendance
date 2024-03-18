package com.system.Attendance.service.mapper;

import com.system.Attendance.domain.Event;
import com.system.Attendance.service.contract.EventPayload;
import edu.miu.common.service.mapper.BaseMapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class EventToEventPayloadMapper extends BaseMapper<Event, EventPayload>{

    public EventToEventPayloadMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Event.class, EventPayload.class);
    }

}
