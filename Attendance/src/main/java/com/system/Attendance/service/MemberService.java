package com.system.Attendance.service;

import com.system.Attendance.service.contract.MemberAttendenceOverAccount;
import com.system.Attendance.domain.Member;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.service.BaseReadWriteService;

import java.util.List;


public interface MemberService extends BaseReadWriteService <MembersPayload, Member, Integer>{

    List<MemberAttendenceOverAccount> getMemberAttendanceOverAccount(int memberId);
}