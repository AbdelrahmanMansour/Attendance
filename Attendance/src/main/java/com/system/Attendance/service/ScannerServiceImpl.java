package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Scanner;
import com.system.Attendance.domain.Session;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.repository.SessionRepository;
import com.system.Attendance.service.contract.MembersPayload;
import com.system.Attendance.service.contract.RecordPayload;
import com.system.Attendance.service.contract.ScannerPayload;
import com.system.Attendance.service.contract.SessionPayload;
import com.system.Attendance.service.mapper.MemberToMembersPayloadMapper;
import com.system.Attendance.service.mapper.SessionToSessionPayloadMapper;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ScannerServiceImpl extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Integer> implements ScannerService {

    @Autowired
    private MemberToMembersPayloadMapper memberToMembersPayloadMapper;

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public List<RecordPayload> fetchRecords(Long scannerCode) {
        List<Member> members = membersRepository.findAll();
        List<RecordPayload> recordPayloads = new ArrayList<>();
        members.forEach(member -> {
            member.getSessions().forEach(session -> {
                if (session.getScanner().getId().equals(scannerCode)) {
                    RecordPayload recordPayload = new RecordPayload();
                    MembersPayload membersPayload = memberToMembersPayloadMapper.map(member);
                    recordPayload.setMembersPayload(membersPayload);
                    SessionPayload sessionPayload = SessionPayload.fromSession(session);
                    recordPayload.setSessionPayload(sessionPayload);
                    recordPayloads.add(recordPayload);
                }
            });
        });

        return recordPayloads;
    }

    @Override
    public void createMemberSessionRecord(RecordPayload recordPayload) {
        Member member = membersRepository.findById(recordPayload.getMemberId()).get();
        Session session = sessionRepository.findById(recordPayload.getSessionId()).get();
        if(member.getSessions() != null && member.getSessions().contains(session)){
            return;
        }
        member.getSessions().add(session);
        membersRepository.save(member);
    }

    @Override
    public void updateMemberSessionRecord(RecordPayload recordPayload) {
        Member member = membersRepository.findById(recordPayload.getMemberId()).get();
        Session session = sessionRepository.findById(recordPayload.getSessionId()).get();
        if(member.getSessions() != null && member.getSessions().contains(session)){
            member.getSessions().remove(session);
            membersRepository.save(member);
        }
    }


}
