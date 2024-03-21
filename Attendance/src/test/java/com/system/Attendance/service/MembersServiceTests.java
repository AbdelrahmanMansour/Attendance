package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Role;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.repository.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class MembersServiceTests {

    private Member createTestMember(){
        return new Member(
                "ilmedovamahri",
                "Mahri",
                "Ilmedova",
                "123",
                200.0,
                "ilmedovamahri@gmail.com"
        );
    }

    @Mock
    private MembersRepository memberRepository;

    @Mock
    private RoleRepository roleRepository;

    private MemberService memberService;


    @BeforeEach
    public void setUp() {
        memberService = new MembersServiceImpl(
                memberRepository,
                roleRepository
        );
    }

    @Test
    public void assignedRolesTest(){
        final var expectedRoles = List.of(
                new Role("admin","admin desc"),
                new Role("student","student desc")
        );

        for(int i = 0; i < expectedRoles.size(); i++){
            expectedRoles.get(i).setId(Long.valueOf(i+1));
        }

        expectedRoles.forEach( (role) ->
                Mockito.when(
                        roleRepository.findById(Math.toIntExact(role.getId()))
                ).thenReturn(Optional.of(role))
        );

        final var member = createTestMember();
        member.setId(1L);

        Mockito.when(memberRepository.findById(Math.toIntExact(1L))).thenReturn(Optional.of(member));

        Iterable<Integer> newRoleIds = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        for (Role expectedRole : expectedRoles) {
            Long id = expectedRole.getId();
            list.add(Math.toIntExact(id));
        }
        final var response = memberService.bulkAssignRoles(Math.toIntExact(member.getId()), list);

        final var expArray = expectedRoles.stream().map(Role::getId).toArray();
        final var actualArray = response.stream().map(Role::getId).toArray();

        Arrays.sort(expArray);
        Arrays.sort(actualArray);

        Assertions.assertArrayEquals(expArray, actualArray);
    }


    @Test
    public void removeAssignedRoleTest(){
        final var member = createTestMember();
        member.setId(1L);

        final var role1 = new Role("admin","admin desc");
        final var role2 = new Role("student","student desc");

        final var expectedRoles = List.of(role1,role2);

        for(int i = 0; i < expectedRoles.size(); i++){
            expectedRoles.get(i).setId(Long.valueOf(i+1));
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Role expectedRole : expectedRoles) {
            Long id = expectedRole.getId();
            list.add(Math.toIntExact(id));
        }

        memberService.bulkAssignRoles(Math.toIntExact(member.getId()), list);

        memberService.removeRoleFromMember(Math.toIntExact(member.getId()), Math.toIntExact(role1.getId()));

        Assertions.assertFalse(member.getRoles().contains(role1));
    }

}