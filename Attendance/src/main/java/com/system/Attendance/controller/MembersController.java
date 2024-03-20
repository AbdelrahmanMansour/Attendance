package com.system.Attendance.controller;

import com.system.Attendance.DTO.BulkAssignRolesDTO;
import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Role;
import com.system.Attendance.repository.RoleRepository;
import com.system.Attendance.service.MembersService;
import com.system.Attendance.service.RoleService;
import com.system.Attendance.service.contract.MembersPayload;
import com.system.Attendance.service.contract.RolePayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MembersController extends BaseReadWriteController<MembersPayload, Member, Long> {
    @Autowired
    MembersService membersService;

    @GetMapping("/{id}/roles")
    public List<Role> rolesOfMember(@PathVariable("id") Long id){
        return membersService.findById(id).getRoles();
    }

    @PostMapping("/{id}/roles")
    public List<Role> assignRolesToMember(@PathVariable("id") Long id, @RequestBody BulkAssignRolesDTO request){
        return membersService.bulkAssignRoles(id, request.roleIds());
    }

    @DeleteMapping("/{id}/roles/{roleId}")
    public void bulkRemoveRolesFromMember(@PathVariable("id") Long id, @PathVariable("roleId") Integer roleId){
        membersService.removeRoleFromMember(id, roleId);
    }
}
