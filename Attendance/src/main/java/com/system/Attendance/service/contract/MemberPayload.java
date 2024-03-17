package com.system.Attendance.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberPayload implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer memberId;
	
	private String name;

}
