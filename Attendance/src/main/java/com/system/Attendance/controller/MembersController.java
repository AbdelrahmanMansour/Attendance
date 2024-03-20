package com.system.Attendance.controller;

import com.system.Attendance.domain.Member;
import com.system.Attendance.service.MembersService;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MembersController extends BaseReadWriteController<MembersPayload, Member, Integer> {

    @Autowired
    private MembersService memberService;
    @GetMapping("/{memberId}/events/{eventId}/attendance")
    public ResponseEntity<Integer> countAttendanceForEventByMember(@PathVariable("memberId") Integer memberId,
                                                                   @PathVariable("eventId") Long eventId){

        int attendanceCount = memberService.countAttendanceForEventByMember(memberId, eventId);
        return new ResponseEntity<>(attendanceCount, HttpStatus.OK);
    }
}
