package com.system.Attendance.controller;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Scanner;
import com.system.Attendance.domain.Session;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.repository.SessionRepository;
import com.system.Attendance.service.MembersService;
import com.system.Attendance.service.ScannerService;
import com.system.Attendance.service.contract.MembersPayload;
import com.system.Attendance.service.contract.RecordPayload;
import com.system.Attendance.service.contract.ScannerPayload;
import com.system.Attendance.service.contract.SessionPayload;
import com.system.Attendance.service.mapper.MemberToMembersPayloadMapper;
import com.system.Attendance.service.mapper.SessionToSessionPayloadMapper;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/scanners")
public class ScannerController extends BaseReadWriteController<ScannerPayload, Scanner, Integer> {

    @Autowired
    private ScannerService scannerService;

    @GetMapping("{scannerCode}/records")
    public List<RecordPayload> fetchRecords(@PathVariable Long scannerCode) {
        return scannerService.fetchRecords(scannerCode);
    }

    @PostMapping("{scannerCode}/records")
    public void createMemberSessionRecord( @RequestBody RecordPayload recordPayload) {
       scannerService.createMemberSessionRecord(recordPayload);
    }
}
