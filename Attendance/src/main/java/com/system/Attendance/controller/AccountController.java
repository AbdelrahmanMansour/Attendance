package com.system.Attendance.controller;


import com.system.Attendance.domain.Account;
import com.system.Attendance.service.EventServiceImpl;
import com.system.Attendance.service.contract.AccountPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/accounts")
public class AccountController extends BaseReadWriteController<AccountPayload, Account, Long> {

    @Autowired
    EventServiceImpl eventService;

}
