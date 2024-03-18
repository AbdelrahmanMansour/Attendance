package com.system.Attendance.service;

import com.system.Attendance.domain.Location;
import com.system.Attendance.service.contract.LocationPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl extends BaseReadWriteServiceImpl<LocationPayload, Location, Integer> implements LocationService {
	
}
