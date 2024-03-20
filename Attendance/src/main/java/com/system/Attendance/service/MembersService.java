package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.service.contract.MemberAttendenceOverAccount;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.service.BaseReadWriteService;

import java.util.List;

public interface MembersService extends BaseReadWriteService<MembersPayload, Member, Integer> {
    int countAttendanceForEventByMember(Integer memberId, Long eventId);

    List<MemberAttendenceOverAccount> getMemberAttendanceOverAccount(int memberId);
}
