package com.system.Attendance.service;

import com.system.Attendance.service.contract.MemberAttendenceOverAccount;
import com.system.Attendance.service.contract.MemberPayload;
import com.system.Attendance.domain.Member;
import edu.miu.common.service.BaseReadWriteService;

import java.util.List;


public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Integer>{

    List<MemberAttendenceOverAccount> getMemberAttendanceOverAccount(int memberId);
}
