package com.system.Attendance.service;

import com.system.Attendance.domain.Scanner;
import com.system.Attendance.service.contract.ScannerPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class ScannerServiceImpl extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Integer> implements ScannerService {

}
