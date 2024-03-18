package com.system.Attendance.controller;


import com.system.Attendance.domain.Location;
import com.system.Attendance.service.contract.LocationPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class LocationController extends BaseReadWriteController<LocationPayload, Location, Integer> {

}
