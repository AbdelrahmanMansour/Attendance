package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersServiceImpl extends BaseReadWriteServiceImpl<MembersPayload, Member, Integer> implements MembersService{

    @Autowired
    EventRepository eventRepository;
    @Override
    public int countAttendanceForEventByMember(Integer memberId, Long eventId) {
        return eventRepository.countAttendanceForEventByMember(memberId, eventId);
    }
}
