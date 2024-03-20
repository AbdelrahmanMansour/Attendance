package com.system.Attendance.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class MembersPayload implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String firstName;

    private String lastName;

    private String barCode;

    private Double balance;

    private String email;

}
