package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Scanner;
import com.system.Attendance.domain.Session;
import com.system.Attendance.service.contract.MemberPayload;
import com.system.Attendance.service.contract.MemberSessionPayload;
import com.system.Attendance.service.contract.ScannerPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ScannerServiceImpl extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Integer> implements ScannerService {

    private final MemberService memberService;

    private final EventService eventService;

    public void createMemberSessionRecord(MemberSessionPayload memberSessionPayload) {
        //mem
//        MemberPayload member = memberService.findById(memberSessionPayload.getMemberId());
//
//        Event
                System.out.println("Scanning");
    }
}
