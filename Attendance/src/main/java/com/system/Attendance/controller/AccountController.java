package com.system.Attendance.controller;


import com.system.Attendance.domain.Account;
import com.system.Attendance.service.contract.AccountPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController extends BaseReadWriteController<AccountPayload, Account, Long> {
}
