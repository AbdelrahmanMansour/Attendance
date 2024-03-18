package com.system.Attendance.service.mapper;

import com.system.Attendance.domain.Role;
import com.system.Attendance.service.contract.RolePayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RoleToRolePayloadMapper extends BaseMapper<Role, RolePayload> {

    public RoleToRolePayloadMapper(MapperFactory mapperFactory){
        super(mapperFactory, Role.class, RolePayload.class);
    }
}
