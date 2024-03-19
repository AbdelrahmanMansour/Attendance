package com.system.Attendance.controller;

import com.system.Attendance.domain.Scanner;
import com.system.Attendance.service.contract.ScannerPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/scanners")
public class ScannerController extends BaseReadWriteController<ScannerPayload, Scanner, Integer> {

    @PostMapping("/{scannerCode}/records")
    public void createMemberSessionRecord() {
        //
        System.out.println("Scanning");
    }
}
