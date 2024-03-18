package com.system.Attendance.DTO;

import com.system.Attendance.domain.Session;
import com.system.Attendance.service.contract.SessionPayload;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface SessionMapper {
    SessionMapper MAPPER = Mappers.getMapper(SessionMapper.class);
    SessionPayload toPayload(Session session);
    Session toEntity(SessionPayload sessionPayload);
}