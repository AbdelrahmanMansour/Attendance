package com.system.Attendance.service;

import com.system.Attendance.domain.Location;
import com.system.Attendance.service.contract.LocationPayload;
import edu.miu.common.service.BaseReadWriteService;


public interface LocationService extends BaseReadWriteService <LocationPayload, Location, Integer>{

}
