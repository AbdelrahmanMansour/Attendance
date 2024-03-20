package com.system.Attendance.service.contract;

import com.system.Attendance.domain.Account;
import com.system.Attendance.domain.Location;
import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Schedule;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
public class EventPayload implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    private Schedule schedule;

    private Location location;

    private Account account;
}
