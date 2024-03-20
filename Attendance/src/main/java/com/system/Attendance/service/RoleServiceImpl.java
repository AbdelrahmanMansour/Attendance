package com.system.Attendance.service;

import com.system.Attendance.domain.Role;
import com.system.Attendance.repository.RoleRepository;
import com.system.Attendance.service.contract.RolePayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl extends BaseReadWriteServiceImpl<RolePayload, Role, Integer> implements RoleService{
    private final RoleRepository roleRepository;

    @Transactional
    @Override
    public void deleteInBatch(Iterable<Integer> ids) {
        roleRepository.deleteAllRoleRefsInMemberRole(ids);
        super.deleteInBatch(ids);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        roleRepository.deleteAllRoleRefsInMemberRole(List.of(id));
        super.delete(id);
    }
}
