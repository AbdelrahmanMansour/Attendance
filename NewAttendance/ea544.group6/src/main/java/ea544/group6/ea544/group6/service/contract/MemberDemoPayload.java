package ea544.group6.ea544.group6.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberDemoPayload implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer memberId;

    private String name;

}