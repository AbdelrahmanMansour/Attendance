package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Role;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.service.BaseReadWriteService;

import java.util.List;

public interface MembersService extends BaseReadWriteService<MembersPayload, Member, Integer> {
    public List<Role> bulkAssignRoles(Integer id, Iterable<Integer> ids);

    public void removeRoleFromMember(Integer memberId, Integer roleId);
}
