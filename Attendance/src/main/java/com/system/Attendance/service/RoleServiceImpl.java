package com.system.Attendance.service;

import com.system.Attendance.domain.Role;
import com.system.Attendance.service.contract.RolePayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseReadWriteServiceImpl<RolePayload, Role, Integer> implements RoleService{
}
