package com.system.Attendance.controller;

import com.system.Attendance.domain.Scanner;
import com.system.Attendance.domain.Session;
import com.system.Attendance.service.ScannerService;
import com.system.Attendance.service.contract.MembersPayload;
import com.system.Attendance.service.contract.ScannerPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/scanners")
public class ScannerController extends BaseReadWriteController<ScannerPayload, Scanner, Integer> {
    @Autowired
    private ScannerService scannerService;



    @GetMapping("/{scannerCode}/records")
    public ResponseEntity<List<MembersPayload>> fetchScannerRecords(@PathVariable Integer scannerCode) {
        List<MembersPayload> membersPayloadList = scannerService.fetchScannerRecords(scannerCode);
        return ResponseEntity.ok(membersPayloadList);

    }
    @GetMapping("/{scannerCode}/records/{memberId}")
    public ResponseEntity<MembersPayload> fetchScanRecord(@PathVariable Integer scannerCode, @PathVariable Integer memberId) {
        MembersPayload membersPayload = scannerService.fetchScanRecord(scannerCode, memberId);
        return ResponseEntity.ok(membersPayload);
    }
    @PostMapping("/{scannerCode}/records")
    public void createScanRecord( @RequestBody MembersPayload membersPayload) {
        scannerService.createScanRecord(membersPayload);
    }
    @DeleteMapping("/{scannerCode}/records/{memberId}")
    public void deleteScanRecord(@PathVariable Integer scannerCode) {
        scannerService.deleteScanRecord(scannerCode);
    }
    @PutMapping("/{scannerCode}/records/{memberId}")
    public void updateScanRecord(@PathVariable Integer scannerCode, @RequestBody MembersPayload membersPayload) {
        scannerService.updateScanRecord(scannerCode, membersPayload);
    }



}
