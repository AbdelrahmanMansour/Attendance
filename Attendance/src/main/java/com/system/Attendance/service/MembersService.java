package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.service.BaseReadWriteService;

public interface MembersService extends BaseReadWriteService<MembersPayload, Member, Integer> {
}
