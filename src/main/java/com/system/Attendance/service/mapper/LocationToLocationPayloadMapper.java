package com.system.Attendance.service.mapper;

import com.system.Attendance.domain.Location;
import com.system.Attendance.service.contract.LocationPayload;
import edu.miu.common.service.mapper.BaseMapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class LocationToLocationPayloadMapper extends BaseMapper<Location, LocationPayload> {

	public LocationToLocationPayloadMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Location.class, LocationPayload.class);
	}

}
