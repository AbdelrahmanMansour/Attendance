package com.system.Attendance.controller;

import com.system.Attendance.service.MemberService;
import com.system.Attendance.service.contract.MemberAttendenceOverAccount;
import com.system.Attendance.domain.Member;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MembersController extends BaseReadWriteController<MembersPayload, Member, Integer> {

    @Autowired
    private MemberService memberService;
    @GetMapping("/{memberId}/attendance")
    public List<MemberAttendenceOverAccount> getMemberAttendanceAccountType(@PathVariable("memberId") int memberId) {
        return memberService.getMemberAttendanceOverAccount(memberId);
    }
}
