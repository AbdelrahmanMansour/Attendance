package com.system.Attendance.service.contract;

import com.system.Attendance.domain.Account;
import com.system.Attendance.domain.Location;
import com.system.Attendance.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class ScannerPayload implements Serializable {
    private static final long serialVersionUID = 1L;

    private Location location;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private Long id;
}
