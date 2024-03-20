package com.system.Attendance.service;

import com.system.Attendance.domain.*;
import com.system.Attendance.repository.AccountRepository;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.service.contract.AccountPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.modelmapper.internal.util.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl extends BaseReadWriteServiceImpl<AccountPayload, Account, Long> implements AccountService {


    @Autowired
    AccountRepository accountRepository;

    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Member> getAttendance(Long accountId) {
        List<Member> memberslist = new ArrayList<>();
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        List<Event> eventlist = eventRepository.findByAccount(optionalAccount.get().getId());
        for(Event event : eventlist){
             List<Session> sessionlist =event.getSchedule().getSessions();
             for (Session session : sessionlist){
                 List<Member> members = session.getMemberList();
                 memberslist.addAll(members);
             }
        }
        return memberslist;
    }
}
