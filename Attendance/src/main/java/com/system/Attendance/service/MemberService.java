package com.system.Attendance.service;

import com.system.Attendance.service.contract.MemberPayload;
import com.system.Attendance.domain.Member;
import edu.miu.common.service.BaseReadWriteService;
import org.springframework.data.repository.query.Param;


public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Integer>{
    int calculateAttendance(Long memberId, Long eventId);
}
