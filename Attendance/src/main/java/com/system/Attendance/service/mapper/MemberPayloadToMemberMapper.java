package com.system.Attendance.service.mapper;

import com.system.Attendance.service.contract.MemberPayload;
import com.system.Attendance.domain.Member;
import edu.miu.common.service.mapper.BaseMapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class MemberPayloadToMemberMapper extends BaseMapper<MemberPayload, Member>{

	public MemberPayloadToMemberMapper(MapperFactory mapperFactory) {
		super(mapperFactory, MemberPayload.class, Member.class);
	}
}
