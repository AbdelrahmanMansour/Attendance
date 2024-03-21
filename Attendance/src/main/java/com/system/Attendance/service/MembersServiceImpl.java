package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Role;
import com.system.Attendance.enums.AccountType;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.repository.RoleRepository;
import com.system.Attendance.service.contract.MemberAttendenceOverAccount;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
//@AllArgsConstructor
public class MembersServiceImpl extends BaseReadWriteServiceImpl<MembersPayload, Member, Integer> implements MemberService {

    @Autowired
    private MembersRepository memberRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    RoleRepository roleRepository;

    public MembersServiceImpl(){

    }

    public MembersServiceImpl(MembersRepository membersRepository, RoleRepository roleRepository){
        this.roleRepository = roleRepository;
        this.memberRepository = membersRepository;
    }

    @Override
    public List<MemberAttendenceOverAccount> getMemberAttendanceOverAccount(int memberId) {
        List<Object[]> list = memberRepository.getMemberAttendanceOverAccount(memberId);
        List<MemberAttendenceOverAccount> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            AccountType accountType = (AccountType) list.get(i)[0];
            long count = (long) list.get(i)[1];
            MemberAttendenceOverAccount member = new MemberAttendenceOverAccount(accountType, count);
            result.add(member);
        }
        return result;
    }

    @Transactional
    public List<Role> bulkAssignRoles(Integer memberId, Iterable<Integer> ids){
        final var member = memberRepository.findById(memberId).orElse(null);
        List<Role> roles = new ArrayList<>();
        for(Integer id: ids){
            roleRepository.findById(id).ifPresent(roles::add);
        }
        if(member != null){
            member.setRoles(roles);
            return member.getRoles();
        }
        return new ArrayList<>();
    }

    @Transactional
    public void removeRoleFromMember(Integer memberId, Integer roleId){
        memberRepository.findById(memberId).ifPresent(member -> member.unsetRole(roleId));
    }
}
