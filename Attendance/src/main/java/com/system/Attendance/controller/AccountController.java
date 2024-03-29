package com.system.Attendance.controller;


import com.system.Attendance.domain.Account;
import com.system.Attendance.domain.Member;
import com.system.Attendance.service.EventServiceImpl;
import com.system.Attendance.service.contract.AccountPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/accounts")
public class AccountController extends BaseReadWriteController<AccountPayload, Account, Long> {

    @Autowired
    EventServiceImpl eventService;

    @PostMapping("/{eventID}/addMembers")
    public ResponseEntity<?> addMembersToEvent(@PathVariable Long eventID, @RequestParam Set<Member> members){
        return new ResponseEntity<>(
                eventService.addMembersToEvent(eventID, members), HttpStatus.OK);

    }

}
