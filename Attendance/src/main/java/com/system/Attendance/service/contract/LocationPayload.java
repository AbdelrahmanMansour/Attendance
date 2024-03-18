package com.system.Attendance.service.contract;

import com.system.Attendance.enums.LocationType;
import lombok.Data;

import java.io.Serializable;

@Data
public class LocationPayload implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer locationid;
	private String name;
	private String description;
	private LocationType locationType;
}
