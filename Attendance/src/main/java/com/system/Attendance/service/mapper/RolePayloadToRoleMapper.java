package com.system.Attendance.service.mapper;

import com.system.Attendance.domain.Role;
import com.system.Attendance.service.contract.RolePayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RolePayloadToRoleMapper extends BaseMapper<RolePayload, Role> {

    public RolePayloadToRoleMapper(MapperFactory mapperFactory){
        super(mapperFactory, RolePayload.class, Role.class);
    }
}
