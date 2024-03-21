package com.system.Attendance.service.mapper;

import com.system.Attendance.domain.Member;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class MembersPayloadToMemberMapper extends BaseMapper<MembersPayload, Member> {

    public MembersPayloadToMemberMapper(MapperFactory mapperFactory) {
        super(mapperFactory, MembersPayload.class, Member.class);
    }
}
