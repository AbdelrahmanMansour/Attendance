package com.system.Attendance.repository;

import com.system.Attendance.domain.*;
import com.system.Attendance.enums.AccountType;
import com.system.Attendance.enums.LocationType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    MembersRepository memberRepository;
    @Test
    public void getAttendanceOfMemberHaveTwoAccount() {

        // Add location
        Location daibyHall = new Location("location", "eatting location", LocationType.DINING);
        entityManager.persist(daibyHall);

        // add scanner
        Scanner scanner = new Scanner(daibyHall);
        entityManager.persist(scanner);

        // add account
        Account eating = new Account("eating","eating account", AccountType.EATING);
        Account virtualDolar = new Account("virtual Dolar","Virtual Dolar", AccountType.VIRTUAL_DOLLAR);
        entityManager.persist(eating);
        entityManager.persist(virtualDolar);

        // set scanner for account
        eating.setScanner(scanner);

        // crate role
        Role role = new Role("student", "student role");

        // set relation between role and account
        role.setAccounts(Arrays.asList(eating, virtualDolar));
        entityManager.persist(role);

        // create member
        Member member = new Member("student1","first name", "last name","1111", 1000.0, "email");
        member.setRoles(Arrays.asList(role));
        Member savedMember = entityManager.persist(member);

        // create session
        Session session = new Session("10:00", "12:00");
        Session session2 = new Session("14:00", "16:00");

        // same scanner
        scanner.addSession(session);
        scanner.addSession(session2);

        session.addMember(member);
        session2.addMember(member);

        entityManager.persist(session);
        entityManager.persist(session2);
        entityManager.flush();

        List<Object[]> repoResult = memberRepository.getMemberAttendanceOverAccount(savedMember.getId());

        // 2 account so should return 2 row
        assertThat(2).isEqualTo(repoResult.size());

        AccountType type = (AccountType) repoResult.get(0)[0]; // EATING

        // eating so show the resul
        if (type == AccountType.EATING) {
            assertThat(2).isEqualTo((long) repoResult.get(0)[1]);
        } else {
            assertThat(0).isEqualTo((long) repoResult.get(0)[1]);
        }
    }

    @Test
    public void getEmptyAttendanceOfMemberHaveTwoAccount() {

        // Add location
        Location daibyHall = new Location("location", "eatting location", LocationType.DINING);
        entityManager.persist(daibyHall);

        // add scanner
        Scanner scanner = new Scanner(daibyHall);
        entityManager.persist(scanner);

        // add account
        Account eating = new Account("eating","eating account", AccountType.EATING);
        Account virtualDolar = new Account("virtual Dolar","Virtual Dolar", AccountType.VIRTUAL_DOLLAR);
        entityManager.persist(eating);
        entityManager.persist(virtualDolar);

        // set scanner for account
        eating.setScanner(scanner);

        // crate role
        Role role = new Role("student", "student role");

        // set relation between role and account
        role.setAccounts(Arrays.asList(eating, virtualDolar));
        entityManager.persist(role);

        // create member
        Member member = new Member("student1","first name", "last name","1111", 1000.0, "email");
        member.setRoles(Arrays.asList(role));
        Member savedMember = entityManager.persist(member);

        // create session
        Session session = new Session("10:00", "12:00");
        Session session2 = new Session("14:00", "16:00");

        // same scanner

        scanner.addSession(session);
        scanner.addSession(session2);

        // don't set member to session
//        session.addMember(member);
//        session2.addMember(member);

        entityManager.persist(session);
        entityManager.persist(session2);
        entityManager.flush();

        List<Object[]> repoResult = memberRepository.getMemberAttendanceOverAccount(savedMember.getId());

        // 2 account so should return 2 row
        assertThat(2).isEqualTo(repoResult.size());

        AccountType type = (AccountType) repoResult.get(0)[0]; // EATING

        // eating so show the resul
        if (type == AccountType.EATING) {
            assertThat(0).isEqualTo((long) repoResult.get(0)[1]);
        } else {
            assertThat(0).isEqualTo((long) repoResult.get(0)[1]);
        }
    }
}