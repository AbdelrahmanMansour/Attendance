package com.system.Attendance.service.mapper;

import com.system.Attendance.domain.Session;
import com.system.Attendance.service.contract.SessionPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class SessionPayloadToSessionMapper extends BaseMapper<SessionPayload, Session>{

	public SessionPayloadToSessionMapper(MapperFactory mapperFactory) {
		super(mapperFactory, SessionPayload.class, Session.class);
	}
}
