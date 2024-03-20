package com.system.Attendance.controller;

import com.system.Attendance.domain.Member;
import com.system.Attendance.service.MemberService;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MembersController extends BaseReadWriteController<MembersPayload, Member, Integer> {

    @Autowired
    private MemberService memberService;
    @GetMapping("/{memberId}/attendance")
    public ResponseEntity<?> getMemberAttendanceAccountType(@PathVariable("memberId") int memberId) {
        try {
            return ResponseEntity.ok(this.memberService.getMemberAttendanceOverAccount(memberId));
        }catch (Exception e) {
            return  ResponseEntity.status(500).body("Have problem when get attendance over accounts!");
        }
    }
}
