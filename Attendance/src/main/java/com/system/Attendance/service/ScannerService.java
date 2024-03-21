package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Scanner;


import com.system.Attendance.service.contract.MembersPayload;
import com.system.Attendance.service.contract.ScannerPayload;
import edu.miu.common.service.BaseReadWriteService;

import java.util.List;

public interface ScannerService extends BaseReadWriteService<ScannerPayload, Scanner, Integer> {

    List<MembersPayload> fetchScannerRecords(Integer scannerCode);
     void createScanRecord(MembersPayload membersPayload, Integer scannerId );
    void deleteScanRecord(Integer scannerCode);
    MembersPayload updateScanRecord(Integer scannerCode, MembersPayload membersPayload);
    MembersPayload fetchScanRecord(Integer scannerCode, Integer memberId);
}
