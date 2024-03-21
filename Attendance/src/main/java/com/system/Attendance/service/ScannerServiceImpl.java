package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Scanner;
import com.system.Attendance.domain.Session;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.repository.ScannerRepository;
import com.system.Attendance.repository.SessionRepository;
import com.system.Attendance.service.contract.MembersPayload;
import com.system.Attendance.service.contract.ScannerPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class ScannerServiceImpl extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Integer> implements ScannerService {

    @Autowired
    private ScannerRepository scannerRepository;
    @Autowired
    private MembersRepository membersRepository;
    @Autowired
    private SessionRepository sessionRepository;


    @Override
    public List<MembersPayload> fetchScannerRecords(Integer scannerCode) {
        Optional<Scanner> optionalScanner = scannerRepository.findById(scannerCode);
        if (optionalScanner.isPresent()) {
            Scanner scanner = optionalScanner.get();
            List<Session> sessions = scanner.getSessions();
            if (sessions != null) {
                List<MembersPayload> membersPayloadList = new ArrayList<>();
                for (Session session : sessions) {
                    List<Member> members = session.getMemberList();
                    if (members != null) {
                        for (Member member : members) {
                            MembersPayload memberPayload = new MembersPayload();
                            memberPayload.setFirstName(member.getName());
                            memberPayload.setLastName(member.getLastName());
                            memberPayload.setEmail(member.getEmail());

                            membersPayloadList.add(memberPayload);
                        }
                    }
                }
                return membersPayloadList;
            }
        }
        return Collections.emptyList();
    }

    @Override
    public void createScanRecord(MembersPayload membersPayload, Integer sessionId ) {
        Optional<Session> session = sessionRepository.findById(sessionId);
        Optional<Member> member = membersRepository.findById(membersPayload.getId());
        if (member.isPresent()) {

            if (session.isPresent()) {
                Session session1 = session.get();
                session1.getMemberList().add(member.get());
                sessionRepository.save(session1);
            }
        }
    }

    @Override
    public void deleteScanRecord(Integer scannerCode) {
        Optional<Scanner> scanner = scannerRepository.findById(scannerCode);
        if (scanner.isPresent()) {
            if (scanner.get().getSessions() != null) {
                for (Session session : scanner.get().getSessions()) {
                    if (session.getMemberList() != null) {
                        session.getMemberList().clear();
                    }
                }
            }
        }
    }

    @Override
    public MembersPayload updateScanRecord(Integer scannerCode, MembersPayload membersPayload) {
        Optional<Scanner> scanner = scannerRepository.findById(scannerCode);
        if (scanner.isPresent() && scanner.get().getSessions() != null) {

            for (Session session : scanner.get().getSessions()) {
                if (session.getMemberList() != null) {
                    List<Member> members = session.getMemberList();
                    for (Member member : members) {
                        if (member.getId().equals(membersPayload.getId())) {
                            member.setName(membersPayload.getFirstName());
                            member.setLastName(membersPayload.getLastName());
                            member.setEmail(membersPayload.getEmail());
                            membersRepository.save(member);
                            return membersPayload;
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    public MembersPayload fetchScanRecord(Integer scannerCode, Integer memberId) {
        Optional<Scanner> scanner = scannerRepository.findById(scannerCode);
        if (scanner.isPresent() && scanner.get().getSessions() != null) {
            for (Session session : scanner.get().getSessions()) {
                if (session.getMemberList() != null) {
                    List<Member> members = session.getMemberList();
                    for (Member member : members) {
                        if (member.getId().equals(memberId)) {
                            MembersPayload membersPayload = new MembersPayload();
                            membersPayload.setFirstName(member.getName());
                            membersPayload.setLastName(member.getLastName());
                            membersPayload.setEmail(member.getEmail());
                            return membersPayload;
                        }
                    }
                }
            }
        }
        return null;
    }
}

