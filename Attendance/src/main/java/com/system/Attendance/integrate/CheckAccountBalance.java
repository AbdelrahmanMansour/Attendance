package com.system.Attendance.integrate;

import com.system.Attendance.domain.Member;
import com.system.Attendance.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckAccountBalance {

    @Autowired
    MembersRepository membersRepository;

    @Autowired
    JMSSenderImpl jmsSender;

//    @Scheduled(cron="*/5 * * * * *")
    public void checkAccounts(){
        List<Member> members = membersRepository.findByBalanceLessThan(200.0);
        for (Member member: members){
            jmsSender.sendJMSMessage(member.getEmail()+"_"+member.getName()+"your balance is below 5%");
        }
    }
}
