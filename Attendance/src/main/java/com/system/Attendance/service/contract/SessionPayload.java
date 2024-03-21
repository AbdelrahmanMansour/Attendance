package com.system.Attendance.service.contract;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Schedule;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SessionPayload implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;

	private String startTime;

	private String endTime;

	private List<Member> memberList;


}
