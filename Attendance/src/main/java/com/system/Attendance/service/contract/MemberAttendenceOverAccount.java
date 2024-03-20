package com.system.Attendance.service.contract;


import com.system.Attendance.enums.AccountType;
import lombok.Data;

import java.io.Serializable;

@Data
public class MemberAttendenceOverAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private AccountType accountType;
    private long count;
}
