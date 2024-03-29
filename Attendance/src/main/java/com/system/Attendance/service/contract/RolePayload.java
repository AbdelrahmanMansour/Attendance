package com.system.Attendance.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolePayload implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String description;
}
