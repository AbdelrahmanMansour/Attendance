package com.system.Attendance.service;

import com.system.Attendance.domain.Account;
import com.system.Attendance.service.contract.AccountPayload;
import edu.miu.common.service.BaseReadWriteService;

public interface AccountService extends BaseReadWriteService<AccountPayload, Account, Long> {

}
