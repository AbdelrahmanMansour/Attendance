package com.system.Attendance.service.contract;

import com.system.Attendance.domain.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    private List<Role> roles = new ArrayList<Role>();

}
