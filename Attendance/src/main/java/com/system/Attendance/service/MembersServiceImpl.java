package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MembersServiceImpl extends BaseReadWriteServiceImpl<MembersPayload, Member, Integer> implements MembersService{
}
