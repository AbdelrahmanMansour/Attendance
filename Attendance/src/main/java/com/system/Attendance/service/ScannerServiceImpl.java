package com.system.Attendance.service;

import com.system.Attendance.domain.Scanners;
import com.system.Attendance.service.contract.ScannerPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class ScannerServiceImpl extends BaseReadWriteServiceImpl<ScannerPayload, Scanners, Integer> implements ScannerService {

}
