package com.system.Attendance.integrate;

import com.system.Attendance.domain.*;
import com.system.Attendance.enums.AccountType;
import com.system.Attendance.enums.LocationType;
import com.system.Attendance.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GenerateData {
    private List<Member> listMember = new ArrayList<>();
    private List<Session> listSession = new ArrayList<>();

    private List<Schedule> listSchedule = new ArrayList<>();

    private int maxMember = 100;
    private  int sessionPerEvent = 10;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ScannerRepository scannerRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    SessionRepository sessionRepository;



    @Transactional
    public void generateData() {
        // Crate location
        Location dainingHall = new Location("Agiro", "the place to take food", LocationType.DINING);
        Location library = new Location("Library", "The place to read book", LocationType.LIBRARY);
        Location verillHall = new Location("VerillHall", "the place to Study", LocationType.CLASSROOM);
        Location guy = new Location("Gym Center", "the place do exercise", LocationType.GYM);
        locationRepository.saveAll(Arrays.asList(dainingHall, library, verillHall, guy));

        // create Account
        Account eatingAccount = new Account("eating", "Account for eat", AccountType.EATING);
        Account attendenceAccount = new Account("attendence", "Account for attendence", AccountType.ATTENDANCE);
        Account virtualDolarAccout = new Account("virtualDolar", "Account for Virtual Dolar", AccountType.VIRTUAL_DOLLAR);

        accountRepository.saveAll(Arrays.asList(eatingAccount, attendenceAccount, virtualDolarAccout));

        // create Scanner
        Scanner scannerEating = new Scanner("11111111", dainingHall, eatingAccount);
        Scanner scannerAttendance1 = new Scanner("22222222", library, attendenceAccount);
        Scanner scannerAttendance2 = new Scanner("33333333", verillHall, attendenceAccount);
        Scanner scannerVirtualDolar = new Scanner("44444444", guy, virtualDolarAccout);

        scannerRepository.saveAll(Arrays.asList(scannerEating, scannerAttendance1, scannerAttendance2, scannerVirtualDolar));

        // create Role
        Role student = new Role("student role", "role for student");
        Role faculty = new Role("faculty role", "role for faculty");
        Role guess = new Role("fuess role", "role for faculty");

        roleRepository.saveAll(Arrays.asList(student, faculty, guess));

        // create event
        Event eatingEvent = new Event("eating", "event for eating");
        Event classEvent = new Event("class event", "event for class ");
        Event gymEvent = new Event("gym event", "event for gym");

        eventRepository.saveAll(Arrays.asList(eatingEvent, classEvent, gymEvent));

        // add accout role
        student.setAccounts(Arrays.asList(attendenceAccount, eatingAccount));
        attendenceAccount.addRole(student);
        eatingAccount.addRole(student);

        faculty.setAccounts(Arrays.asList(attendenceAccount, eatingAccount, virtualDolarAccout));
        attendenceAccount.addRole(faculty);
        eatingAccount.addRole(faculty);
        virtualDolarAccout.addRole(faculty);

        guess.setAccounts(Arrays.asList(virtualDolarAccout));
        virtualDolarAccout.addRole(guess);

        // Create member
        for(int i = 0 ;i < maxMember; i++) {
            Member member = new Member("studnet_" + i, "firstName_"+i, "lastName" + i, "1111"+i, 100.0 + i * 10, "email_" + i);
            // student
            if (i % 2 == 0) {
                member.setRoles(Arrays.asList(student));
                student.addMember(member);
                member.setEventList(Arrays.asList(eatingEvent, classEvent));
                eatingEvent.addMember(member);
                classEvent.addMember(member);
            } else if (i % 5 == 0) {
                // faculty
                member.setRoles(Arrays.asList(faculty));
                faculty.addMember(member);
                member.setEventList(Arrays.asList(eatingEvent, classEvent));
                eatingEvent.addMember(member);
                classEvent.addMember(member);
            } else {
                // guess
                member.setRoles(Arrays.asList(guess));
                guess.addMember(member);
                member.setEventList(Arrays.asList(eatingEvent));
                eatingEvent.addMember(member);
            }
            listMember.add(member);
        }
        memberRepository.saveAll(listMember);

        // create session
        Schedule eatingSchedule = new Schedule("from:MondayTo:Friday");
        Schedule classSchedule = new Schedule("Monday-Wednesday-Friday");
        Schedule gymSchedule = new Schedule("Sunday");
        listSchedule.add(eatingSchedule);
        listSchedule.add(classSchedule);
        listSchedule.add(gymSchedule);
        scheduleRepository.saveAll(listSchedule);

        for (int i = 0 ; i < listSchedule.size(); i ++) {
            // crate sesssion
            for(int se = 0 ; se < sessionPerEvent; se ++) {
                Session session = new Session(LocalDateTime.now(), LocalDateTime.now());
                listSchedule.get(i).addSession(session);
                for (int mem = 0; mem < maxMember; mem ++) {
                    if (i == 0) { // eating schedule for every body
                        session.addMember(listMember.get(mem));
                        listMember.get(mem).addSession(session);
                    } else if ((mem % 2 ==  0 || mem % 5 == 0) && i == 1) // class schedule for student and faculty
                    {
                        session.addMember(listMember.get(mem));
                        listMember.get(mem).addSession(session);
                    } else if (mem % 2 == 0 && i == 2) { // gym schedule for student
                        session.addMember(listMember.get(mem));
                        listMember.get(mem).addSession(session);
                    }
                }
                listSession.add(session);
            }
        }
        sessionRepository.saveAll(listSession);


    }
}
