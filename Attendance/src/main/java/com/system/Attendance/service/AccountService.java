package com.system.Attendance.service;

import com.system.Attendance.domain.Account;
import com.system.Attendance.domain.Member;
import com.system.Attendance.service.contract.AccountPayload;
import edu.miu.common.service.BaseReadWriteService;
import org.modelmapper.internal.util.Members;

import java.util.List;

public interface AccountService extends BaseReadWriteService<AccountPayload, Account, Long> {

    List<Member> getAttendance(Long accountId);
}
