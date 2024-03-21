package com.system.Attendance.controller;


import com.system.Attendance.service.ScannerService;
import com.system.Attendance.service.contract.MembersPayload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ScannerControllerRestTest {

    @Mock
    private ScannerService scannerService;

    @InjectMocks
    private ScannerController scannerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void fetchScannerRecords() {

        int scannerCode = 123;
        List<MembersPayload> expectedMembersPayloadList = Collections.singletonList(new MembersPayload());
        when(scannerService.fetchScannerRecords(scannerCode)).thenReturn(expectedMembersPayloadList);
        ResponseEntity<List<MembersPayload>> responseEntity = scannerController.fetchScannerRecords(scannerCode);
        assertEquals(expectedMembersPayloadList, responseEntity.getBody());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void fetchScanRecord() {

        int scannerCode = 123;
        int memberId = 456;
        MembersPayload expectedMembersPayload = new MembersPayload();
        when(scannerService.fetchScanRecord(scannerCode, memberId)).thenReturn(expectedMembersPayload);
        ResponseEntity<MembersPayload> responseEntity = scannerController.fetchScanRecord(scannerCode, memberId);
        assertEquals(expectedMembersPayload, responseEntity.getBody());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void createScanRecord() {

        int scannerCode = 123;
        MembersPayload membersPayload = new MembersPayload();
        scannerController.createScanRecord(membersPayload, scannerCode);
        verify(scannerService, times(1)).createScanRecord(membersPayload, scannerCode);
    }

    @Test
    void deleteScanRecord() {

        int scannerCode = 123;
        scannerController.deleteScanRecord(scannerCode);
        verify(scannerService, times(1)).deleteScanRecord(scannerCode);
    }

    @Test
    void updateScanRecord() {

        int scannerCode = 123;
        MembersPayload membersPayload = new MembersPayload();
        scannerController.updateScanRecord(scannerCode, membersPayload);
        verify(scannerService, times(1)).updateScanRecord(scannerCode, membersPayload);
    }
}
