package com.system.Attendance.service.contract;


import lombok.Data;

import java.io.Serializable;

@Data
public class MemberAttendenceOverAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accountType;
    private long count;
}
