package com.system.Attendance.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberSessionPayload implements Serializable {
private static final long serialVersionUID = 1L;

  private Long id;

  private Integer memberId;

  private Long sessionId;
}
