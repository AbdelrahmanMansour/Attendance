package com.system.Attendance.controller;

import com.system.Attendance.domain.Scanners;
import com.system.Attendance.service.contract.ScannerPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/scanners")
public class ScannerController extends BaseReadWriteController<ScannerPayload, Scanners, Integer> {

}
