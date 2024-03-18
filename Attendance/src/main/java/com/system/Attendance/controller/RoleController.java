package com.system.Attendance.controller;

import com.system.Attendance.domain.Role;
import com.system.Attendance.service.contract.RolePayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController extends BaseReadWriteController<RolePayload, Role, Integer> {
}
