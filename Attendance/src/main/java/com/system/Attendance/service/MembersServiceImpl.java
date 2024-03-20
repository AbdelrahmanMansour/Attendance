package com.system.Attendance.service;
import com.system.Attendance.domain.Member;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.service.contract.MemberAttendenceOverAccount;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembersServiceImpl extends BaseReadWriteServiceImpl<MembersPayload, Member, Integer> implements MemberService {
    @Autowired
    private MembersRepository memberRepository;
    @Override
    public List<MemberAttendenceOverAccount> getMemberAttendanceOverAccount(int memberId) {
        List<Object[]> list = memberRepository.getMemberAttendanceOverAccount(memberId);
        List<MemberAttendenceOverAccount> result = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            MemberAttendenceOverAccount member = new MemberAttendenceOverAccount();
            String accountType = (String) list.get(i)[0];
            long count = (long)list.get(i)[1];
            member.setAccountType(accountType);
            member.setCount(count);
            result.add(member);
        }
        return result;
    }
}
