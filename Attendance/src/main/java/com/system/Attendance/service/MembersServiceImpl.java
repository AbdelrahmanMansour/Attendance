package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Role;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.repository.RoleRepository;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MembersServiceImpl extends BaseReadWriteServiceImpl<MembersPayload, Member, Long> implements MembersService
{
    @Autowired
    MembersRepository membersRepository;

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public List<Role> bulkAssignRoles(Long memberId, Iterable<Integer> ids){
        final var member = membersRepository.findById(memberId).orElse(null);
        List<Role> roles = new ArrayList<>();
        for(Integer id: ids){
            var role = roleRepository.findById(id).orElse(null);
            if(role != null){
                roles.add(role);
            }
        }
        if(member != null){
            member.setRoles(roles);
            return member.getRoles();
        }
        return new ArrayList<>();
    }

    @Transactional
    public void removeRoleFromMember(Long memberId, Integer roleId){
        final var member = membersRepository.findById(memberId).orElse(null);
        if(member != null){
            member.unsetRole(roleId);
        }
    }
}
