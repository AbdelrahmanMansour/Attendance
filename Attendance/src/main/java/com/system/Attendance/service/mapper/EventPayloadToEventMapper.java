package com.system.Attendance.service.mapper;

import com.system.Attendance.domain.Event;
import com.system.Attendance.service.contract.EventPayload;
import edu.miu.common.service.mapper.BaseMapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class EventPayloadToEventMapper extends BaseMapper<EventPayload, Event>{

    public EventPayloadToEventMapper(MapperFactory mapperFactory) {
        super(mapperFactory, EventPayload.class, Event.class);
    }

}
