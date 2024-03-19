package com.system.Attendance.controller;


import com.system.Attendance.service.MemberService;
import com.system.Attendance.service.contract.MemberPayload;
import com.system.Attendance.domain.Member;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController extends BaseReadWriteController<MemberPayload, Member, Integer> {
    @Autowired
    private MemberService memberService;
    @GetMapping("/{memberId}/events/{eventId}/attendance")
    public ResponseEntity<Integer> getAttendanceForEvent(@PathVariable("memberId") Long memberId,
                                                         @PathVariable("eventId") Long eventId) {
        int attendanceCount = memberService.calculateAttendance(memberId, eventId);
        return ResponseEntity.ok(attendanceCount);
    }
}