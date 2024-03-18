package com.system.Attendance.service.contract;

import com.system.Attendance.domain.Account;
import com.system.Attendance.domain.Location;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class ScannerPayload implements Serializable {
    private static final long serialVersionUID = 1L;

    private String scannerCode;

    private Location location;
    private Account account;

    private Long id;
}
