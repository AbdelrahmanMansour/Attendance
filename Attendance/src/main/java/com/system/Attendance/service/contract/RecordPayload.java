package com.system.Attendance.service.contract;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordPayload {

    private MembersPayload membersPayload;

    private SessionPayload sessionPayload;

    private Integer sessionId;

    private Integer memberId;
}
