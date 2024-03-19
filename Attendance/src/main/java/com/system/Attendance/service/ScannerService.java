package com.system.Attendance.service;


import com.system.Attendance.domain.Scanner;

import com.system.Attendance.service.contract.ScannerPayload;
import edu.miu.common.service.BaseReadWriteService;

import java.util.List;

public interface ScannerService extends BaseReadWriteService<ScannerPayload, Scanner, Integer> {

}
