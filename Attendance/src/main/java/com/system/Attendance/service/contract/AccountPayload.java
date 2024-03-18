package com.system.Attendance.service.contract;


import com.system.Attendance.domain.Role;
import com.system.Attendance.enums.AccountType;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AccountPayload implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Double defaultBalance;
    private AccountType type = AccountType.EATING;
    private List<Role> roles = new ArrayList<Role>();
}
