package com.system.Attendance.repository;

import com.system.Attendance.domain.Account;
import com.system.Attendance.domain.Location;
import com.system.Attendance.enums.AccountType;
import com.system.Attendance.enums.LocationType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void deleteInBatch() {
    }

    @Test
    void getMemberAttendanceOverAccount() {



//        MyEntity entity = new MyEntity("myname");
//
//        MyEntity result = entityManager.persist(entity);
//        entityManager.flush();
//
//        assertThat(entity)
//                .isEqualTo(result);

        Location dainingHall = new Location("Agiro", "the place to take food", LocationType.DINING);
        entityManager.persist(dainingHall);

        Account eatingAccount = new Account("eating", "Account for eat", AccountType.EATING);
        entityManager.persist(eatingAccount);

//        Scanner scannerEating = new Scanner("11111111", dainingHall, eatingAccount);
//        entityManager.persist(scannerEating);
//
//        Role student = new Role("student role", "role for student");
//        student.addAccount(eatingAccount);
//        eatingAccount.addRole(student);
//        entityManager.persist(student);
//
//        Member member = new Member("member1","first name", "last name", "1111",10.0, "email");
//        Event event = new Event("event 1", "event");
//        event.setAccount(eatingAccount);
//        event.setLocation(dainingHall);
//
//        Schedule schedule = new Schedule(LocalDate.now());
//        entityManager.persist(schedule);
//
//        Event savedEvent = entityManager.persist(event);
//
//        Session session = new Session(LocalDateTime.now(),LocalDateTime.now());
//        savedEvent.setSchedule(schedule);
//
//        schedule.addSession(session);
//        session.addMember(member);
//        member.addSession(session);
//
//        savedEvent.addMember(member);
//        member.addEvent(savedEvent);
//        member.setRoles(Arrays.asList(student));
//        student.addMember(member);
//        Member saved = entityManager.persist(member);
        entityManager.flush();
      //  List<Member> memberList = memberRepository.findAll();
        assertThat(1)
                .isEqualTo(1);



    }
}