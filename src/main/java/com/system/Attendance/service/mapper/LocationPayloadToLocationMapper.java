package com.system.Attendance.service.mapper;

import com.system.Attendance.domain.Location;
import com.system.Attendance.service.contract.LocationPayload;
import edu.miu.common.service.mapper.BaseMapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class LocationPayloadToLocationMapper extends BaseMapper<LocationPayload, Location>{

	public LocationPayloadToLocationMapper(MapperFactory mapperFactory) {
		super(mapperFactory, LocationPayload.class, Location.class);
	}
}
