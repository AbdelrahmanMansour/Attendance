package com.system.Attendance.service;

import com.system.Attendance.service.contract.MemberPayload;
import com.system.Attendance.domain.Member;
import edu.miu.common.service.BaseReadWriteServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends BaseReadWriteServiceImpl<MemberPayload, Member, Integer> implements MemberService {
	
}
