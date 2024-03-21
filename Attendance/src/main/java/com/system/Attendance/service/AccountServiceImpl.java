package com.system.Attendance.service;

import com.system.Attendance.domain.*;
import com.system.Attendance.repository.AccountRepository;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.service.contract.AccountPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.modelmapper.internal.util.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl extends BaseReadWriteServiceImpl<AccountPayload, Account, Long> implements AccountService {


    @Autowired
    AccountRepository accountRepository;

    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Member> getAttendance(Long accountId, String startDate, String endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_Date = dateFormat.parse(startDate);
        Date end_Date = dateFormat.parse(endDate);
        List<Member> memberslist = new ArrayList<>();
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        List<Event> eventlist = eventRepository.findByAccount(optionalAccount.get().getId());
        List<Member> members = new ArrayList<>();
        for(Event event : eventlist){
             List<Session> sessionlist =event.getSchedule().getSessions();
             for (Session session : sessionlist){
                 Date session_start_Date = dateFormat.parse(session.getStartTime());
                 Date session_end_Date = dateFormat.parse(session.getEndTime());
                 if((session_start_Date.after(start_Date)  && session_end_Date.before(end_Date))){
                     members.addAll(session.getMemberList());
                 }
                 memberslist.addAll(members);
             }
        }
        return memberslist;
    }
}
