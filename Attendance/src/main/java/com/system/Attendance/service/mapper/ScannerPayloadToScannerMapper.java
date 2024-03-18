package com.system.Attendance.service.mapper;


import com.system.Attendance.domain.Scanners;
import com.system.Attendance.service.contract.ScannerPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class ScannerPayloadToScannerMapper extends BaseMapper<ScannerPayload, Scanners> {

    public ScannerPayloadToScannerMapper(MapperFactory mapperFactory) {
        super(mapperFactory, ScannerPayload.class, Scanners.class);
    }
}
