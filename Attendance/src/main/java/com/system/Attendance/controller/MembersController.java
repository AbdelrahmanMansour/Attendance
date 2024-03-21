package com.system.Attendance.controller;

import com.system.Attendance.DTO.BulkAssignRolesDTO;
import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Role;
import com.system.Attendance.service.EventService;
import com.system.Attendance.service.MemberService;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.controller.BaseReadWriteController;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MembersController extends BaseReadWriteController<MembersPayload, Member, Integer> {

    @Autowired
    private MemberService memberService;

    @Autowired
    EventService eventService;
    @GetMapping("/{memberId}/attendance")
    public ResponseEntity<?> getMemberAttendanceAccountType(@PathVariable("memberId") int memberId) {
        try {
            return ResponseEntity.ok(this.memberService.getMemberAttendanceOverAccount(memberId));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Have problem when get attendance over accounts!");
        }
    }

    @GetMapping("/{memberId}/events/{eventId}/attendance")
    public ResponseEntity<Integer> countAttendanceForEventByMember(@PathVariable("memberId") Long memberId,
                                                                   @PathVariable("eventId") Long eventId){

        int attendanceCount = eventService.countAttendanceForEventByMember(memberId, eventId);
        return new ResponseEntity<>(attendanceCount, HttpStatus.OK);
    }

    @GetMapping("/{id}/roles")
    public List<Role> rolesOfMember(@PathVariable("id") Integer id){
        return memberService.findById(id).getRoles();
    }

    @PostMapping("/{id}/roles")
    public List<Role> assignRolesToMember(@PathVariable("id") Integer id, @RequestBody BulkAssignRolesDTO request){
        return memberService.bulkAssignRoles(id, request.roleIds());
    }

    @DeleteMapping("/{id}/roles/{roleId}")
    public void bulkRemoveRolesFromMember(@PathVariable("id") Integer id, @PathVariable("roleId") Integer roleId){
        memberService.removeRoleFromMember(id, roleId);
    }
}
