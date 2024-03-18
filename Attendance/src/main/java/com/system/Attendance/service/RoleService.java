package com.system.Attendance.service;

import com.system.Attendance.domain.Role;
import com.system.Attendance.service.contract.RolePayload;
import edu.miu.common.service.BaseReadWriteService;

public interface RoleService extends BaseReadWriteService<RolePayload, Role, Integer> {
}
