package com.system.Attendance.service.mapper;


import com.system.Attendance.domain.Scanner;
import com.system.Attendance.service.contract.ScannerPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class ScannerPayloadToScannerMapper extends BaseMapper<ScannerPayload, Scanner> {

    public ScannerPayloadToScannerMapper(MapperFactory mapperFactory) {
        super(mapperFactory, ScannerPayload.class, Scanner.class);
    }
}
